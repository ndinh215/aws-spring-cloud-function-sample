package com.company.functions;

import com.company.models.CommonRequest;
import com.company.models.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.logging.Logger;

@Component
public class CommonFunction implements Function<CommonRequest, CommonResponse> {

    private static final Logger LOG = Logger.getLogger(String.valueOf(CommonFunction.class));

    @Override
    public CommonResponse apply(CommonRequest request) {
        CommonResponse response = new CommonResponse();
        response.setResult(request.getData().toUpperCase());

        LOG.info("[INFO] " + response.getResult());

        return response;
    }
}
