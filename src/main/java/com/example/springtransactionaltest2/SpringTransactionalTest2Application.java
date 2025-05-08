package com.example.springtransactionaltest2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class SpringTransactionalTest2Application implements CommandLineRunner {


    private final CallerService callerService;

    public SpringTransactionalTest2Application(CallerService callerService) {
        this.callerService = callerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionalTest2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        callerService.createInvalidContact();
    }
}
