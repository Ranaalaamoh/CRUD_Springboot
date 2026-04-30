package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;
    
    public UserDTO createUser(UserDTO userDTO) {
        User user =userMapper.toUser(userDTO);
        user = userRepo.save(user);
        return userMapper.toUserDTO(user);
    }


  public Page<UserDTO> getUsers(Pageable pageable) {
    Page<User> users = userRepo.findAll(pageable);
    return users.map(userMapper::toUserDTO);
}

 public UserDTO getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toUserDTO(user);
    }



    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setFullName(userDTO.getFullName() != null ? userDTO.getFullName() : user.getFullName());
        user.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : user.getEmail());
        user.setRole(userDTO.getRole() != null ? userDTO.getRole() : user.getRole());
        user.setIsActive(userDTO.getIsActive() != null ? userDTO.getIsActive() : user.getIsActive());
        user = userRepo.save(user);
        return userMapper.toUserDTO(user);
    }



    public UserDTO deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user);
        return userMapper.toUserDTO(user);
    }

    

    public UserDTO updateUserStatus(Long id, UserDTO userDTO) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setIsActive(userDTO.getIsActive());
        user = userRepo.save(user);
        return userMapper.toUserDTO(user);
    }

}
