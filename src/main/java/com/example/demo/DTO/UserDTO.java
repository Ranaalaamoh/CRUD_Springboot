package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.Enum.UserRole;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {
    
    private Long id;

    @NotBlank(message = "Full name is required")
    @Size(min = 3, message = "Full name must be at least 3 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message="Invalid email format")
    private String email;

    @NotNull(message = "Role is required")
    private UserRole role;


    private Boolean isActive = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
