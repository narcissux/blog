package com.narcissux.blog;

import com.mysql.jdbc.util.Base64Decoder;
import com.narcissux.blog.common.utils.JwtUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {

    @Test
    public void generate() {
        System.out.println(JwtUtils.generateToken(1008));
    }

    @Test
    public void getClaims() {
        String token ="eyJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIxMDA4IiwiaXNzIjoieGlheWUiLCJ1aWQiOjEwMDgsImdyb3VwIjoibmFyY2lzc3V4IiwiZXhwIjoxNTcyNTU4ODE1fQ.MV35tztM5yofVVIdHFMikeS3OzSW3aR1WmWZjbiyh1yncJ4yCPxXWT2RDAuPVSzTyWbPVZmoQT32yujBLmw9Jn3HOJeaQvB1RosV3e7Q5nxjgh6xJqQgTBEuS3HjRRNBoShN-BthFkghxOTCa2sUidI9BXZNh768gH0ZfgM-g-0evMOThg4Zbk4kxy7DA3frhOMzlD29kKvZ67QtDLqXcbTlttK2-Q1Mf6jt3Nycm4eVITZqBFaZsCJ7VWxHMlE6m_U6eLsaKCgtZt_HoRPOjs1iPswejLBJRAtoB8hjy0JZf-u6O_3X1MdZBQBXlOJxBuUrJeB16WKwZmgMeJIaQA";
        System.out.println(JwtUtils.getClaim(token));
        System.out.println(new Date(3000L));

    }

    @Test
    public void getClaimsWithoutKey() {
        String token ="eyJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIxMDA4IiwiaXNzIjoieGlheWUiLCJ1aWQiOjEwMDgsImdyb3VwIjoibmFyY2lzc3V4IiwiZXhwIjoxNTcyNTU4ODE1fQ.MV35tztM5yofVVIdHFMikeS3OzSW3aR1WmWZjbiyh1yncJ4yCPxXWT2RDAuPVSzTyWbPVZmoQT32yujBLmw9Jn3HOJeaQvB1RosV3e7Q5nxjgh6xJqQgTBEuS3HjRRNBoShN-BthFkghxOTCa2sUidI9BXZNh768gH0ZfgM-g-0evMOThg4Zbk4kxy7DA3frhOMzlD29kKvZ67QtDLqXcbTlttK2-Q1Mf6jt3Nycm4eVITZqBFaZsCJ7VWxHMlE6m_U6eLsaKCgtZt_HoRPOjs1iPswejLBJRAtoB8hjy0JZf-u6O_3X1MdZBQBXlOJxBuUrJeB16WKwZmgMeJIaQA";
        System.out.println(JwtUtils.getJson(token));
        Long exp = JwtUtils.getJson(token).getLong("exp");
        Instant instant = Instant.ofEpochMilli(exp);
        System.out.println(LocalDateTime.ofInstant(instant,ZoneId.systemDefault()));
        System.out.println(exp);
        System.out.println(new Date(JwtUtils.getJson(token).getLong("exp")));

    }

    @Test
    public void decodeClaims(){
        String token ="eyJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIxMjM0NTYiLCJpc3MiOiJ4aWF5ZSIsInVpZCI6MTIzNDU2LCJncm91cCI6Im5hcmNpc3N1eCIsImV4cCI6MTU1NzMwMTQxM30.eFKjLUVLiIjTebFWAwsdN_oU5QTnLdVBmZbztWfvDJ8734cO-diWicD5UR_J1TxZoUTS6lCHXYt5hH-H74gR4mkFNs5r9ab2Ev55bEveNXiWRTzvWFgZMMVFG9HGCgg8Jy-IiYjZL2TBaokP9fpkhD0RnVH0AJcuwbtdn02kfCfxH4LtdCpHRg5llnIIKk7PKiJbPvm_5TCQKnkYTn8d8lAf4cfnyEsyEyrReVz9SnJt4EpakKhu2m32KDkJA7hRB2NmZvcbwXHaXxlK-deH4XwUJPbVKtQZj-FjWe5EXuGb6_zslvSQneBpEV1EdwIG2nnq5Iz__Zxx7FfbU6zS-Q";
        String[] s = token.split("\\.");
        String str;
        try {

            str = new String(Base64.decodeBase64(s[1].getBytes()));
            System.out.println("解码"+str);
        }catch (Exception e){

        }
    }


    @Test
    public void generateWithExpire(){
        System.out.println(JwtUtils.generateToken(1008,1000*60*60*24*365*10L));
    }



}