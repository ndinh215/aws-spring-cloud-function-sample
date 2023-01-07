package com.company.functions;

import com.company.models.MemberRequest;
import com.company.models.MemberResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.logging.Logger;

@Component
public class UtilsFunction implements Function<MemberRequest, MemberResponse> {

    private static final Logger LOG = Logger.getLogger(String.valueOf(UtilsFunction.class));

    @Override
    public MemberResponse apply(MemberRequest memberRequest) {
        MemberResponse response = new MemberResponse();
        response.setMemberId(memberRequest.getMemberId());
        response.setMemberName(memberRequest.getMemberName().toUpperCase());

        LOG.info("[INFO] " + response.getMemberId());

        return response;
    }
}
