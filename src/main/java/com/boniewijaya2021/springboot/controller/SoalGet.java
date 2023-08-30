package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.TblSales;
//import com.boniewijaya2021.springboot.entity.TblUsers;
//import com.boniewijaya2021.springboot.entity.TblMobil;
//import com.boniewijaya2021.springboot.entity.TblOrang;
import com.boniewijaya2021.springboot.pojo.MobilPostPojo;
import com.boniewijaya2021.springboot.pojo.OrangPostPojo;
//import com.boniewijaya2021.springboot.pojo.UsersPostPojo;
import com.boniewijaya2021.springboot.service.*;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/soal")
public class SoalGet {

//    @Autowired
//    private SalesService salesService;

    @Autowired
    private MobilService mobilService;

    @Autowired
    private OrangService orangService;

//    @Autowired
//    private SalesPostService salesPostService;

    @Autowired
    private OrangPostService orangPostService;

    @Autowired
    private MobilPostService mobilPostService;



//    @GetMapping("/get/dataPenjualan")
//    public ResponseEntity getDataPenjualan(@RequestParam UUID idSales ){
//        ResponseEntity responseEntity = salesService.getDataPenjualan(idSales);
//        return responseEntity;
//
//    }
//    @GetMapping("/get/dataPenjualanClass")
//    public ResponseEntity getDataPenjualanDinamic( String namaSales, String namaBarang){
//        ResponseEntity responseEntity = salesService.getPenjualanClassrepo(namaSales, namaBarang);
//        return responseEntity;
//    }

    @GetMapping("/get/dataMobilClass")
    public ResponseEntity getDataMobilDinamic( String namaOrang, Integer age, String city){
//        , Integer age, String city, String consumerType
        ResponseEntity responseEntity = mobilService.getMobilClassrepo(namaOrang, age, city);
//        , age, city, consumerType
        return responseEntity;
    }

    @GetMapping("/get/dataOrangClass")
    public ResponseEntity getDataOrangDinamic( String nama, String email){
        ResponseEntity responseEntity = orangService.getOrangClassrepo(nama, email);
        return responseEntity;
    }


//    @PostMapping("/post/sales")
//    private ResponseEntity<MessageModel> addSales(@RequestBody TblSales tblSales) {
//        ResponseEntity responseEntity = salesPostService.addDataPenjualan(tblSales);
//        return responseEntity;
//    }

//    @PostMapping("/post/users")
//    private ResponseEntity<MessageModel> addUsers(@RequestBody UsersPostPojo usersPostPojo) {
//        ResponseEntity responseEntity = salesPostService.addDataUsers(usersPostPojo);
//        return responseEntity;
//    }

    @PostMapping("/post/orang")
    private ResponseEntity<MessageModel> addOrang(@RequestBody OrangPostPojo orangPostPojo) {
        ResponseEntity responseEntity = orangPostService.addDataOrang(orangPostPojo);
        return responseEntity;
    }

    @PostMapping("/post/mobil")
    private ResponseEntity<MessageModel> addMobil(@RequestBody MobilPostPojo mobilPostPojo) {
        ResponseEntity responseEntity = mobilPostService.addDataMobil(mobilPostPojo);
        return responseEntity;
    }
}
