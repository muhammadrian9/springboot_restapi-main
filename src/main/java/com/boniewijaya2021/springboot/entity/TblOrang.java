package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_orang", schema = "soal")
public class TblOrang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nama_orang", nullable = false)
    private String nama;

    @Column(name = "usia", nullable = false)
    private Integer usia;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "urlweb1", nullable = false)
    private String urlweb1;

    @Column(name = "descweb1", nullable = false)
    private String descweb1;

    @Column(name = "urlweb2", nullable = false)
    private String urlweb2;

    @Column(name = "descweb2", nullable = false)
    private String descweb2;

    @Column(name = "sosialmedia", nullable = false)
    private String sosialmedia;

    @Column(name = "urlsosmed1", nullable = false)
    private String urlsosmed1;

    @Column(name = "descsosmed1", nullable = false)
    private String descsosmed1;

    @Column(name = "urlsosmed2", nullable = false)
    private String urlsosmed2;

    @Column(name = "descsosmed2", nullable = false)
    private String descsosmed2;

    @Column(name = "urlsosmed3", nullable = false)
    private String urlsosmed3;

    @Column(name = "descsosmed3", nullable = false)
    private String descsosmed3;





}
//@Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(columnDefinition = "serial")
//  private Long id;
//  private String email;
//  private String password;

