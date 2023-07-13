package com.sdu.internalcommon.response;

import lombok.Data;

/**
 * @author LHP
 * @date 2023-07-13 9:06
 * @description
 */

@Data
public class DriverUserExistsResponse {

    private String driverPhone;

    private int ifExists;

}
