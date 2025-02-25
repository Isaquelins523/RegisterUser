package com.Lins.RegisterUser_Java_Spring.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String > {}
