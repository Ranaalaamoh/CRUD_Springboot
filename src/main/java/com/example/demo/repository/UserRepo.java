package com.example.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
        @Override    
        Page<User> findAll( Pageable pageable);

}
