package com.ritesh.insightdocs.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class SignupRequest {
    private String email;
    private String password;
    private String fullName;
    private String nickName;
    private String countryCode;
    private String number;
}
