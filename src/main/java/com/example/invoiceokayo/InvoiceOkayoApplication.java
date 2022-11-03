package com.example.invoiceokayo;

import com.example.invoiceokayo.controller.FactureController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InvoiceOkayoApplication {

    @Autowired
    private FactureController factureController;

    public static void main(String[] args) {
        SpringApplication.run(InvoiceOkayoApplication.class, args);
    }
/*
    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            factureController.findAll();
        };
    }
*/
}
