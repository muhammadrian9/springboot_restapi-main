package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblOrang;
import com.boniewijaya2021.springboot.pojo.OrangPostPojo;
import com.boniewijaya2021.springboot.repository.OrangRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrangPostService {

    @Autowired
    private OrangRepository orangRepository;


    public ResponseEntity<MessageModel> addDataOrang(OrangPostPojo orangPostPojo)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();


        try{
            TblOrang tblOrang = new TblOrang();
            tblOrang.setNama(orangPostPojo.getNama());
            tblOrang.setUsia(orangPostPojo.getUsia());
            tblOrang.setEmail(orangPostPojo.getEmail());
            tblOrang.setWebsite(orangPostPojo.getWebsite());
            tblOrang.setUrlweb1(orangPostPojo.getUrlweb1());
            tblOrang.setDescweb1(orangPostPojo.getDescweb1());

            tblOrang.setUrlweb2(orangPostPojo.getUrlweb2());
            tblOrang.setDescweb2(orangPostPojo.getDescweb2());
            tblOrang.setSosialmedia(orangPostPojo.getSosialmedia());
            tblOrang.setUrlsosmed1(orangPostPojo.getUrlsosmed1());
            tblOrang.setDescsosmed1(orangPostPojo.getDescsosmed1());

            tblOrang.setUrlsosmed2(orangPostPojo.getUrlsosmed2());
            tblOrang.setDescsosmed2(orangPostPojo.getDescsosmed2());
            tblOrang.setUrlsosmed3(orangPostPojo.getUrlsosmed3());
            tblOrang.setDescsosmed3(orangPostPojo.getDescsosmed3());


            orangRepository.save(tblOrang);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblOrang);
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
