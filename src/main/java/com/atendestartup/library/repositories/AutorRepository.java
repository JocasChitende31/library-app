package com.atendestartup.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendestartup.library.entities.Author;

public interface AutorRepository extends JpaRepository<Author, Long> {

	
}
