package com.ensa.tp1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class TestPwdEncoder {

    public static void main(String[] args){

        String pass = "ensa2020";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String r1= encoder.encode(pass);
        String r2= encoder.encode(pass);
        String r3= encoder.encode(pass);

        List<String> reslts = new ArrayList<>();
        reslts.add(r1);
        reslts.add(r2);
        reslts.add(r3);

        reslts.forEach(s -> {
            System.out.println(s + " => " +encoder.matches(pass,s));
        });
    }
}
