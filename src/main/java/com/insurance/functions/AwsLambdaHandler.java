package com.insurance.functions;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class AwsLambdaHandler extends SpringBootRequestHandler<MemberRequest, MemberResponse> {

}
