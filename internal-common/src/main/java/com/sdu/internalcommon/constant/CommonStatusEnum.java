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
