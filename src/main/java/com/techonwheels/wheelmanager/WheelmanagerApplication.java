package com.techonwheels.wheelmanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "WheelManager"))
public class WheelmanagerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WheelmanagerApplication.class, args);
    }
    
}
