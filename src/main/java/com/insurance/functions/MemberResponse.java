package com.insurance.functions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private String memberId;
    private Coverage coverage;

    public enum Coverage {
        MEDICAL, DENTAL, VISION, NONE
    }
}
