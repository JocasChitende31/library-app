package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atendestartup.library.DTO.AuthorDTO;
import com.atendestartup.library.entities.Author;
import com.atendestartup.library.repositories.AutorRepository;

@Service
public class AuthorService {

	@Autowired
	private AutorRepository autorRepository;
	
	@Transactional(readOnly=true)
	public List<AuthorDTO> findAll(){
		
		List<Author> result  = autorRepository.findAll();
		List<AuthorDTO> dto = result.stream().map(x-> new AuthorDTO(x)).toList();
		return dto;
	}
}
