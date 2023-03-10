package com.company.handlers;

import com.company.models.MemberRequest;
import com.company.models.MemberResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class MemberLambdaHandler extends SpringBootRequestHandler<MemberRequest, MemberResponse> {
}
