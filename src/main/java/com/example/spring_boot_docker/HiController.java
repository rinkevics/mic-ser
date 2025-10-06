package com.example.spring_boot_docker;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @GetMapping("/hi")
    public String index() {
        System.out.println("test");
        return "hi" + eurekaClient.getApplication(appName).getName();
    }

}