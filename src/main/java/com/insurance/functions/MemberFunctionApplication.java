package com.insurance.functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class MemberFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberFunctionApplication.class, args);
	}

	@Bean
	public Function<MemberRequest, MemberResponse> members() {
		return member -> {
			MemberResponse response = new MemberResponse();
			response.setMemberId(member.getMemberId());
			response.setCoverage(MemberResponse.Coverage.MEDICAL);
		    return response;
        };
	}

}
