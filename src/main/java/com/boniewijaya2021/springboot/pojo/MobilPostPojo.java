package com.boniewijaya2021.springboot.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class MobilPostPojo {

    private String nama;
    private Integer age;
    private String city;
    private String consumerType;
    private String salesItem;
    private String merek1;
    private String modelmerek1;
    private String merek2;
    private String modelmerek2;
    private String merek3;
    private String modelmerek3;

}
