package com.sdu.internalcommon.dto;

import lombok.Data;

/**
 * @author LHP
 * @date 2023-07-12 9:50
 * @description
 */

@Data
public class PriceRule {

    private String cityCode;

    private Integer vehicleType;

    private double startFare;

    private int startMile;

    private double unitPricePerMile;

    private double unitPricePerMinute;

}
