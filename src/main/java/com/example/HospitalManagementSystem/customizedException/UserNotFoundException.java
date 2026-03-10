package com.example.HospitalManagementSystem.customizedException;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserNotFoundException extends RuntimeException{
        private String errorMsg;
        private Integer errorCode;
        private LocalDateTime dateTime;

        public UserNotFoundException(String errorMsg, Integer errorCode) {
            this.errorMsg = errorMsg;
            this.errorCode = errorCode;
            this.dateTime = LocalDateTime.now();
        }
}
