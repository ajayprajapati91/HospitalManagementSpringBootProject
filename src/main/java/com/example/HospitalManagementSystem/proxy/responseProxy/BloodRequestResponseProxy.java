package com.example.HospitalManagementSystem.proxy.responseProxy;

import com.example.HospitalManagementSystem.enums.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodRequestResponseProxy {
    private Long bloodRequestId;

    @NotBlank(message = "Blood group cannot be empty")
    @Pattern(regexp = "^(?:AB|A|B|O)[+-]$", message = "Invalid blood group format. Use format like 'A+' or 'O-'")
    private String bloodGroup;

    @NotBlank(message = "Quantity should not be null")
    private Integer quantity;

    private LocalDateTime requestDate;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private Long hospitalId;
}
