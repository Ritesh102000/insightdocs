package com.ritesh.insightdocs.security.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class LoginRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 72)
    private String password;
}
