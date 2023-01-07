package com.company.functions;

import com.company.models.MemberRequest;
import com.company.models.MemberResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MemberFunction implements Function<MemberRequest, MemberResponse> {

    @Override
    public MemberResponse apply(MemberRequest memberRequest) {
        MemberResponse response = new MemberResponse();
        response.setMemberId(memberRequest.getMemberId());
        response.setCoverage(MemberResponse.Coverage.MEDICAL);

        return response;
    }
}
