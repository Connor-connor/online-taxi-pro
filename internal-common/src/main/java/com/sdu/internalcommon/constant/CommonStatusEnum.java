package com.sdu.internalcommon.constant;

import lombok.Getter;

/**
 * @author LHP
 * @date 2023-07-10 8:51
 * @description 通用状态枚举
 */
public enum CommonStatusEnum {

        /**
        * 通用状态
        */
        SUCCESS(1, "success"), // 成功
        FAIL(0, "fail"), // 失败
        VERIFICATION_CODE_ERROR(1099, "验证码错误"), // 验证码错误：1000-1099
        TOKEN_ERROR(1199, "token错误"), // token错误：1100-1199
        USER_NOT_EXISTS(1299, "当前用户不存在"), // 用户不存在：1200-1299
        PRICE_NOT_EXISTS(1399, "计价规则不存在"), // 计价规则不存在：1300-1399
        MAP_DISTRICT_ERROR(1499, "请求地图错误"), // 请求地图错误：1400-1499
        ;

        @Getter
        private int code;
        @Getter
        private String value;

        CommonStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

}
