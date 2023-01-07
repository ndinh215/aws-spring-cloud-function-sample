package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private String memberId;
    private String memberName;
    private Coverage coverage;

    public enum Coverage {
        MEDICAL, DENTAL, VISION, NONE
    }
}
