package com.sdu.servicepassengeruser.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author LHP
 * @date 2023-07-11 0:12
 * @description
 */

@Data
public class PassengerUser {

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String passengerPhone;

    private String passengerName;

    private byte passengerGender;

    private byte state;


}
