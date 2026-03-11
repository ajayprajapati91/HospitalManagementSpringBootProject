package com.example.HospitalManagementSystem.proxy.responseProxy;

import com.example.HospitalManagementSystem.entity.Users;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalResponseProxy {
    private Long hospitalId;

    @NotBlank
    private String hospitalName;

    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email should be valid")
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6,max = 10,message = "Password Should be between 6 and 10 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-+=])(?=\\S+$).{8,128}$",
            message = "Password must meet complexity requirements")
    private String password;

    @NotBlank(message = "Address should not be blank")
    private String address;

    @Min(value = 1000000000L,message = "Contact number should not be less than 10 digits")
    @Max(value = 9999999999L,message = "Contact number should not be Greater than 10 digits")
    @Pattern(regexp = "^[6789]\\d{9}$", message = "Invalid contact number format. Must be 10 digits and start with 6, 7, 8, or 9.")
    @NotBlank(message = "contact number should not be blank")
    private String contactNo;

    private Long userId;
    private List<Long> bloodRequestId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;
}
