package com.company.handlers;

import com.company.functions.MemberFunction;
import com.company.models.MemberRequest;
import com.company.models.MemberResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class FunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionApplication.class, args);
    }

    @Bean
    public Function<MemberRequest, MemberResponse> handle() {
        return new MemberFunction();
    }
}
