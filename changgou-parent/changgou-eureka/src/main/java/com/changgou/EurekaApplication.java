package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author huzhpm
 * @Date 2021/1/14 21:54
 * @Version 1.0
 * @Content
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    /**
     * 加载启动类，以启动类为当前Springboot的配置标准
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
