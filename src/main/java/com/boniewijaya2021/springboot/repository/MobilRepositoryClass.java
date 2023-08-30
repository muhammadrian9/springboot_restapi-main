package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblMobil;
import com.boniewijaya2021.springboot.pojo.MobilPostPojo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class MobilRepositoryClass {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MobilPostPojo> getDataDinamic(String nama, Integer age,String city
//             , String consumerType
    )
    {
        StringBuilder qb = new StringBuilder();

        if(nama !=null ){
            qb.append(" and namaorang = :namaOrang \n");
        }
        if(age !=null) {
            qb.append("and age = :age \n");
        }
        if(city !=null) {
            qb.append("and city = :city \n");
        }
//        if(consumerType !=null) {
//            qb.append("and consumer_type = :consumerType \n");
//        }

        String sisipan = qb.toString();

        //untuk sisipan yang ditengah

        String QueryText="SELECT cast (id as varchar) id, namaorang, age,  city, consumer_type, sales_item, merek_mobil1, model_merek1, merek_mobil2, model_merek2, merek_mobil3, model_merek3\n" +
                "FROM soal.tbl_mobil  WHERE 1=1 \n" +sisipan;

        Query query = entityManager.createNativeQuery(QueryText);
        if(nama !=null){
            query.setParameter("namaOrang",nama);
        }
        if(age !=null ){
            query.setParameter("age",age);
        }
        if(city !=null ){
            query.setParameter("city",city);
        }
//        if(consumerType !=null ){
//            query.setParameter("consumerType",consumerType);
//        }

        List hasil= query.getResultList();
        List<MobilPostPojo> result = new ArrayList<>();

        Iterator itr = hasil.iterator();
        while(itr.hasNext()) {
            MobilPostPojo browse = new MobilPostPojo();
            Object[] obj = (Object[]) itr.next();
            String namas = String.valueOf(obj[1]);
            Integer ages = Integer.valueOf((Integer) obj[2]);
            String citys = String.valueOf(obj[3]);
            String consumertype = String.valueOf(obj[4]);
            String salesItem = String.valueOf(obj[5]);
            String merekmobil1 = String.valueOf(obj[6]);
            String modelmerek1 = String.valueOf(obj[7]);
            String merekmobil2 = String.valueOf(obj[8]);
            String modelmerek2 = String.valueOf(obj[9]);
            String merekmobil3 = String.valueOf(obj[10]);
            String modelmerek3 = String.valueOf(obj[11]);

            browse.setNama(namas);
            browse.setCity(citys);
            browse.setAge(ages);
            browse.setConsumerType(consumertype);
            browse.setSalesItem(salesItem);
            browse.setMerek1(merekmobil1);
            browse.setModelmerek1(modelmerek1);
            browse.setMerek2(merekmobil2);
            browse.setModelmerek2(modelmerek2);
            browse.setMerek3(merekmobil3);
            browse.setModelmerek3(modelmerek3);
            result.add(browse);
        }
            return result;
    }
}
