package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblOrang;
import com.boniewijaya2021.springboot.pojo.OrangPostPojo;
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
public class OrangRepositoryClass {

    @PersistenceContext
    private EntityManager entityManager;

    public List<OrangPostPojo> getDataDinamic(String namaOrang, String email
    )
    {
        StringBuilder qb = new StringBuilder();

        if(namaOrang !=null){
            qb.append("and nama_orang = :namaOrang \n");
        }
        if(email !=null ){
            qb.append(" and email = :email \n");
        }


        String sisipan = qb.toString();

        //untuk sisipan yang ditengah

        String QueryText="SELECT cast (id as varchar) id,  nama_orang, usia, email, website, urlweb1, descweb1, urlweb2, descweb2, sosialmedia, urlsosmed1, descsosmed1, urlsosmed2, descsosmed2, urlsosmed3, descsosmed3\n" +
                "FROM soal.tbl_orang  WHERE 1=1 \n" +sisipan;

        Query query = entityManager.createNativeQuery(QueryText);
        if(namaOrang !=null ){
            query.setParameter("namaOrang",namaOrang);
        }
        if(email !=null){
            query.setParameter("email",email);
        }



        List hasil= query.getResultList();
        List<OrangPostPojo> result = new ArrayList<>();

        Iterator itr = hasil.iterator();
        while(itr.hasNext()){
            OrangPostPojo browse = new OrangPostPojo();
            Object[] obj = (Object[]) itr.next();
            String nama = String.valueOf(obj[1]);
            Integer usia = Integer.valueOf((Integer) obj[2]);
            String emails = String.valueOf(obj[3]);
            String website= String.valueOf(obj[4]);
            String urlweb1= String.valueOf(obj[5]);
            String descweb1= String.valueOf(obj[6]);
            String urlweb2= String.valueOf(obj[7]);
            String descweb2= String.valueOf(obj[8]);

            String sosialmedia= String.valueOf(obj[9]);
            String urlsosmed1= String.valueOf(obj[10]);
            String descsosmed1= String.valueOf(obj[11]);
            String urlsosmed2= String.valueOf(obj[12]);
            String descsosmed2= String.valueOf(obj[13]);
            String urlsosmed3= String.valueOf(obj[14]);
            String descsosmed3= String.valueOf(obj[15]);


            browse.setNama(nama);
            browse.setUsia(usia);
            browse.setEmail(emails);
            browse.setWebsite(website);
            browse.setUrlweb1(urlweb1);
            browse.setDescweb1(descweb1);
            browse.setUrlweb2(urlweb2);
            browse.setDescweb2(descweb2);
            browse.setSosialmedia(sosialmedia);
            browse.setUrlsosmed1(urlsosmed1);
            browse.setDescsosmed1(descsosmed1);

            browse.setUrlsosmed2(urlsosmed2);
            browse.setDescsosmed2(descsosmed2);
            browse.setUrlsosmed3(urlsosmed3);
            browse.setDescsosmed3(descsosmed3);

            result.add(browse);
        }
        return result;
    }
}
