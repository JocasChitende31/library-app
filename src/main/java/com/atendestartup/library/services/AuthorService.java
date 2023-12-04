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
	private AutorRepository authorRepository;

	@Transactional(readOnly = true)
	public List<AuthorDTO> findAll() {

		List<Author> result = authorRepository.findAll();
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
	public void createAuthor(String name, String birthday, String nationality) {
		authorRepository.insertAuthor(name, birthday, nationality);
	}
	@Transactional
	public void updateAuthor(Long authId, String name, String birthday, String nationality) {	
		authorRepository.updateAuthor(authId, name, birthday, nationality);
	}
	@Transactional
	public void deleteAuthor(Long authId) {
		authorRepository.deleteById(authId);
	}
}
