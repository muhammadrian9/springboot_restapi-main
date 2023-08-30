package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblMobil;
import com.boniewijaya2021.springboot.pojo.MobilPostPojo;
import com.boniewijaya2021.springboot.repository.MobilRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MobilPostService {

    @Autowired
    private MobilRepository mobilRepository;

    public ResponseEntity<MessageModel> addDataMobil(MobilPostPojo mobilPostPojo)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();


        try{
            TblMobil tblMobil = new TblMobil();

            tblMobil.setNama(mobilPostPojo.getNama());
            tblMobil.setAge(mobilPostPojo.getAge());
            tblMobil.setCity(mobilPostPojo.getCity());
            tblMobil.setConsumerType(mobilPostPojo.getConsumerType());
            tblMobil.setSalesItem(mobilPostPojo.getSalesItem());
            tblMobil.setMerek1(mobilPostPojo.getMerek1());
            tblMobil.setModelmerek1(mobilPostPojo.getModelmerek1());
            tblMobil.setMerek2(mobilPostPojo.getMerek2());
            tblMobil.setModelmerek2(mobilPostPojo.getModelmerek2());
            tblMobil.setMerek3(mobilPostPojo.getMerek3());
            tblMobil.setModelmerek3(mobilPostPojo.getModelmerek3());

            mobilRepository.save(tblMobil);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblMobil);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
