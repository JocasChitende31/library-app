package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atendestartup.labrary.projections.AuthorProjection;
import com.atendestartup.library.DTO.AuthorDTO;
import com.atendestartup.library.entities.Author;
import com.atendestartup.library.repositories.AutorRepository;

@Service
public class AuthorService {

	@Autowired
	private AutorRepository authorRepository;

	@Transactional(readOnly = true)
	public List<AuthorDTO> findAll() {

		List<AuthorProjection> result = authorRepository.findListAuthor();
		List<AuthorDTO> dto = result.stream().map(x -> new AuthorDTO(x)).toList();
		return dto;
	}

	@Transactional
	public AuthorDTO findById(Long authId) {
		Author result = authorRepository.findById(authId).get();
		AuthorDTO dto = new AuthorDTO(result);
		return dto;
	}

	@Transactional
	public void createAuthor(String name, String birthday, String nationality, String status) {
		authorRepository.insertAuthor(name, birthday, nationality, status);
	}
	@Transactional
	public void updateAuthor(Long authId, String name, String birthday, String nationality, String status) {	
		authorRepository.updateAuthor(authId, name, birthday, nationality, status);
	}
	@Transactional
	public void deleteAuthor(Long authId) {
		authorRepository.deleteById(authId);
	}
}
