package com.atendestartup.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.atendestartup.library.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	UserDetails findByLogin(String login);
}
