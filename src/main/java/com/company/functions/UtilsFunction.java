package com.company.functions;

import com.company.models.MemberRequest;
import com.company.models.MemberResponse;

import java.util.function.Function;

public class UtilsFunction implements Function<MemberRequest, MemberResponse> {

    @Override
    public MemberResponse apply(MemberRequest memberRequest) {
        MemberResponse response = new MemberResponse();
        response.setMemberId(memberRequest.getMemberId());
        response.setMemberName(memberRequest.getMemberName().toUpperCase());

        return response;
    }
}
