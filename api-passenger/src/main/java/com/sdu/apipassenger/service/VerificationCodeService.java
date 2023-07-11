package com.sdu.apipassenger.service;

import com.sdu.apipassenger.remote.ServicePassengerUserClient;
import com.sdu.apipassenger.remote.ServiceVerificationcodeClient;
import com.sdu.internalcommon.constant.CommonStatusEnum;
import com.sdu.internalcommon.constant.IdentityConstant;
import com.sdu.internalcommon.dto.ResponseResult;
import com.sdu.internalcommon.request.VerificationCodeDTO;
import com.sdu.internalcommon.response.NumberCodeResponse;
import com.sdu.internalcommon.response.TokenResponse;
import com.sdu.internalcommon.util.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author LHP
 * @date 2023-07-10 1:26
 * @description 验证码服务类
 */

@Service
public class VerificationCodeService {

    // 远程调用service-verificationcode服务
    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    // 远程调用service-passenger-user服务
    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    // 乘客验证码的前缀
    private String verificationCodePrefix = "passenger-verification-code-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据手机号生成redis中的key
     * @param passengerPhone 乘客手机号
     * @return
     */
    private String generateKeyByPhone(String passengerPhone) {
        return verificationCodePrefix + passengerPhone;
    }

    /**
     * 生成验证码
     * @param passengerPhone 乘客手机号
     * @return
     */
    public ResponseResult generatorCode(String passengerPhone) {
        // 调用（远程）验证码服务，获取验证码
        // System.out.println("调用（远程）验证码服务，获取验证码");
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        // System.out.println("remote number code: " + numberCode);

        // 存入redis
        // System.out.println("存入redis");
        // key，value，过期时间
        // key：passenger-verification-code-手机号
        String key = generateKeyByPhone(passengerPhone);
        // 存入redis
        stringRedisTemplate.opsForValue().set(key, numberCode + "", 2, TimeUnit.MINUTES);

        // 通过短信服务商，将对应的验证码发送到手机上，阿里短信服务，腾讯短信通，华信，容联

        // 返回值
        return ResponseResult.success("");
    }

    /**
     * 校验验证码
     * @param passengerPhone 乘客手机号
     * @param verificationCode 验证码
     * @return
     */
    public ResponseResult checkCode(String passengerPhone, String verificationCode) {
        // 根据手机号，去redis中取出验证码
        // 生成redis中的key
        String key = generateKeyByPhone(passengerPhone);
        // 根据key，去redis中取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis中的value: " + codeRedis);
        System.out.println("传入的验证码: " + verificationCode);

        // 校验验证码
        // 如果redis中的验证码为空，或者与传入的验证码不一致，返回错误
        if (StringUtils.isBlank(codeRedis)) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(), CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());

        }
        if (!verificationCode.trim().equals(codeRedis.trim())) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(), CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        // 判断原来是否有用户，并进行相应的处理
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);

        // 颁发令牌
        String token = JwtUtils.generateToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY);

        // 响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);

        return ResponseResult.success(tokenResponse);
    }
}
