package com.sdu.internalcommon.constant;

/**
 * @author LHP
 * @date 2023-07-13 1:47
 * @description
 */

public class DriverCarConstants {

    // 驾驶员车辆关系状态：绑定
    public static int DRIVER_CAR_BIND = 1;

    // 驾驶员车辆关系状态：解绑
    public static int DRIVER_CAR_UNBIND = 2;

    // 驾驶员状态：1：有效
    public static int DRIVER_STATE_VALID = 1;

    // 驾驶员状态：0：无效
    public static int DRIVER_STATE_INVALID = 0;

    // 驾驶员状态：存在：1
    public static int DRIVER_EXISTS = 1;

    // 驾驶员状态：不存在：0
    public static int DRIVER_NOT_EXISTS = 0;

    // 驾驶员工作状态：收车
    public static int DRIVER_WORK_STATUS_STOP = 0;

    // 驾驶员工作状态：出车
    public static int DRIVER_WORK_STATUS_START = 1;

    // 驾驶员工作状态：暂停
    public static int DRIVER_WORK_STATUS_SUSPEND = 2;
}
