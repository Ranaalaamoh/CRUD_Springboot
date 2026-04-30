package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponse;
import com.example.demo.DTO.UserDTO;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    @Operation(summary = "Create a new user", description = "Creates a new user with the given details")
    public ApiResponse<UserDTO> createUser( @Valid @RequestBody UserDTO userDTO) {   
        UserDTO createdUser = userService.createUser(userDTO);
        return ApiResponse.success(createdUser, "User created successfully");
    }

    
    @GetMapping
    @Operation(summary = "Get all users", description = "Returns a paginated list of users")
    public ApiResponse<Page<UserDTO>> getUsers(
        @PageableDefault(size = 10, sort = "id") Pageable pageable
) {
      Page<UserDTO> users = userService.getUsers(pageable);
      return ApiResponse.success(users, "Users retrieved successfully");
}


   @GetMapping("/{id}")
   @Operation(summary = "Get user by ID", description = "Returns the user with the specified ID")
   public ApiResponse<UserDTO> getUserById(@Valid @PathVariable Long id) {
         UserDTO userDTO = userService.getUserById(id);
         return ApiResponse.success(userDTO, "User retrieved successfully");
   }
   @PutMapping("/{id}")
   @Operation(summary = "Update user", description = "Updates the user with the specified ID")
   public ApiResponse<UserDTO> updateUser(@Valid @PathVariable Long id, @RequestBody UserDTO userDTO) {
         UserDTO updatedUser = userService.updateUser(id, userDTO);
         return ApiResponse.success(updatedUser, "User updated successfully");
   }
   @DeleteMapping("/{id}")
   @Operation(summary = "Delete user", description = "Deletes the user with the specified ID")
   public ApiResponse<UserDTO> deleteUser(@Valid @PathVariable Long id) {
         UserDTO deletedUser = userService.deleteUser(id);
         return ApiResponse.success(deletedUser, "User deleted successfully");
   }
   @PatchMapping("/{id}/status")
   @Operation(summary = "Update user status", description = "Updates the status of the user with the specified ID")
   public ApiResponse<UserDTO> updateUserStatus(@Valid @PathVariable Long id, @RequestBody UserDTO userDTO) {
         UserDTO updatedUser = userService.updateUserStatus(id, userDTO);
         return ApiResponse.success(updatedUser, "User status updated successfully");
   }

}
