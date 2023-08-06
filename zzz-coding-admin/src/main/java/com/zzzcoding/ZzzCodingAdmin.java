package com.zzzcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * @author Wenjie Zhang
 * @date 18/9/2022 11:49 pm
 */
@ServletComponentScan
@SpringBootApplication
public class ZzzCodingAdmin {
    public static void main(String[] args) {
        SpringApplication.run(ZzzCodingAdmin.class, args);
    }
}
