package com.atendestartup.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendestartup.library.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	
}
