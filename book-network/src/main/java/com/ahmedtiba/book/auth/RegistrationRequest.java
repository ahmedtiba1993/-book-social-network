package com.ahmedtiba.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "FIRST_NAME_REQUIRED")
    @NotBlank(message = "FIRST_NAME_REQUIRED")
    private String firstname;

    @NotEmpty(message = "LAST_NAME_REQUIRED")
    @NotBlank(message = "LAST_NAME_REQUIRED")
    private String lastname;

    @NotEmpty(message = "EMAIL_REQUIRED")
    @NotBlank(message = "EMAIL_REQUIRED")
    @Email(message = "INVALID_EMAIL_FORMAT")
    private String email;

    @NotEmpty(message = "PASSWORD_REQUIRED")
    @NotBlank(message = "PASSWORD_REQUIRED")
    @Size(min = 8, message = "MINIMUM_PASSWORD_LENGTH_8_CHARACTERS")
    private String password;

}
