package com.boniewijaya2021.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_mobil", schema = "soal")
public class TblMobil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "namaorang", nullable = false)
    private String nama;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "consumer_type", nullable = false)
    private String consumerType;

    @Column(name = "sales_item", nullable = false)
    private String salesItem;

    @Column(name = "merek_mobil1", nullable = false)
    private String merek1;

    @Column(name = "model_merek1", nullable = false)
    private String modelmerek1;

    @Column(name = "merek_mobil2", nullable = false)
    private String merek2;

    @Column(name = "model_merek2", nullable = false)
    private String modelmerek2;

    @Column(name = "merek_mobil3", nullable = false)
    private String merek3;

    @Column(name = "model_merek3", nullable = false)
    private String modelmerek3;

}
//@Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(columnDefinition = "serial")
//  private Long id;
//  private String email;
//  private String password;

