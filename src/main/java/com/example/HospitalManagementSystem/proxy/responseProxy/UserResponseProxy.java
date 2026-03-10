package com.example.HospitalManagementSystem.proxy.responseProxy;

import com.example.HospitalManagementSystem.enums.StatusEnum;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseProxy {
    private Long userId;

    @NotBlank(message = "Name should bot be null")
    private String name;

    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email should be valid")
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6,max = 10,message = "Password Should be between 6 and 10 characters")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-+=])(?=\\S+$).{8,128}$",
//            message = "Password must meet complexity requirements")
    private String password;

    @NotBlank(message = "Role is mandatory")
    private String role;

    @Min(value = 1000000000L,message = "Contact number should not be less than 10 digits")
    @Max(value = 9999999999L,message = "Contact number should not be Greater than 10 digits")
    @Pattern(regexp = "^[6789]\\d{9}$", message = "Invalid contact number format. Must be 10 digits and start with 6, 7, 8, or 9.")
    @NotBlank(message = "contact number should not be blank")
    private String phoneNo;

    @NotBlank(message = "username is mandatory")
    private String username;

    private StatusEnum Status;
}
