package org.java.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UploadApp {
    public static void main(String[] args) {
        SpringApplication.run(UploadApp.class);
    }
}
