package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaServer
public class EurekaApi {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApi.class);
        /////2222222222222222222222
    }
}
