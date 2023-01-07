package com.company.handlers;

import com.company.models.CommonRequest;
import com.company.models.CommonResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class CommonLambdaHandler extends SpringBootRequestHandler<CommonRequest, CommonResponse> {
}
