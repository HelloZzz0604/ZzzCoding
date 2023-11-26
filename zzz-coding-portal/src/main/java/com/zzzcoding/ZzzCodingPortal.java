package com.zzzcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Wenjie Zhang
 * @date 28/9/2023 11:49 pm
 */


@ServletComponentScan
@SpringBootApplication
public class ZzzCodingPortal {
    public static void main(String[] args) {
        SpringApplication.run(ZzzCodingPortal.class, args);
    }
}