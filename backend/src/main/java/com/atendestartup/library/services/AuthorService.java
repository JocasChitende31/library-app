package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atendestartup.library.projections.AuthorProjection;
import com.atendestartup.library.DTO.AuthorDTO;
import com.atendestartup.library.entities.Author;
import com.atendestartup.library.repositories.AutorRepository;

@Service
public class AuthorService {

	@Autowired
	private AutorRepository authorRepository;

	@Transactional
	public AuthorDTO findByName(String name){
		AuthorDTO result = this.authorRepository.findByName(name);
		return result;
	}
	@Transactional(readOnly = true)
	public List<AuthorDTO> findAll() {
		List<AuthorProjection> result = authorRepository.findListAuthor();
		List<AuthorDTO> dto = result.stream().map(x -> new AuthorDTO(x.getId(),x.getName(),x.getBirthday(),x.getNationality(),x.getStatus())).toList();
		return dto;
	}

	@Transactional
	public AuthorDTO findById(Long authId) {
		Author result = authorRepository.findById(authId).get();
		AuthorDTO dto = new AuthorDTO(result.getId(),result.getName(),result.getBirthday(), result.getNationality(), result.getStatus());
		return dto;
	}

	@Transactional
	public void createAuthor(AuthorDTO body) {
		Author newAuthor = new Author(body.id(),body.name(),body.birthday(),body.nationality(),body.status());
		this.authorRepository.save(newAuthor);
	}
	@Transactional
	public void updateAuthor(Long authId, AuthorDTO body) {
		String newName = body.name();
		String newBirthday = body.birthday();
		String newNationality = body.nationality();
		String newStatus = body.status();
		this.authorRepository.updateAuthor(authId, newName, newBirthday, newNationality, newStatus);
	}
	@Transactional
	public void deleteAuthor(Long authId) {
		Author author = this.authorRepository.findById(authId).get();
		this.authorRepository.delete(author);
	}
}
