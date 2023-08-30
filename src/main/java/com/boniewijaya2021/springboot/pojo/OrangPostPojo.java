package com.boniewijaya2021.springboot.pojo;



import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;

@Setter
@Getter
public class OrangPostPojo {


    private String nama;
    private Integer usia;
    private String email;
    private String website;
    private String urlweb1;
    private String descweb1;
    private String urlweb2;
    private String descweb2;

    private String sosialmedia;
    private String urlsosmed1;
    private String descsosmed1;
    private String urlsosmed2;
    private String descsosmed2;
    private String urlsosmed3;
    private String descsosmed3;
}
