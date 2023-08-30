package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblMobil;
import com.boniewijaya2021.springboot.pojo.MobilPostPojo;
import com.boniewijaya2021.springboot.pojo.OrangPostPojo;
import com.boniewijaya2021.springboot.repository.MobilRepositoryClass;
import com.boniewijaya2021.springboot.repository.SalesRepositoryClass;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MobilService {

    @Autowired
    private MobilRepositoryClass mobilRepositoryClass;


    public ResponseEntity getMobilClassrepo(String namaOrang, Integer age, String city){
//        , String consumerType
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            List<MobilPostPojo> data = mobilRepositoryClass.getDataDinamic(namaOrang, age, city );//, city, consumerType//
            if(data.isEmpty()) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }


    }
}
