package com.changgou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author huzhpm
 * @Date 2021/1/16 19:43
 * @Version 1.0
 * @Content
 */
@SpringBootApplication(scanBasePackages = {"com.changgou.goods", "exceptionHandle"})
@EnableEurekaClient
@MapperScan("com.changgou.goods.dao")
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class);
    }
}
