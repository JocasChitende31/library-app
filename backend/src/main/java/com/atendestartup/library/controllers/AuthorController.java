package com.atendestartup.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.library.DTO.AuthorDTO;
import com.atendestartup.library.services.AuthorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping(value = "/authors")
	public List<AuthorDTO> findAll() {
		List<AuthorDTO> result = authorService.findAll();
		return result;
	}

	@GetMapping(value = "/{authId}/author")
	public AuthorDTO findAuthorById(@PathVariable Long authId) {
		AuthorDTO result = authorService.findById(authId);
		return result;
	}

	@PostMapping(value = "/create/author")
	public void createAuthor(@RequestBody AuthorDTO body) {
		String name = body.getName();
		String birthday = body.getBirthday();
		String nationality = body.getNationality();
		String status = body.getStatus();
		authorService.createAuthor(name, birthday, nationality, status);
	}

	@PutMapping(value = "/update/{authId}/author")
	public void updateAuthor(@PathVariable Long authId, @RequestBody AuthorDTO body) {
		String newName = body.getName();
		String newBirthday = body.getBirthday();
		String newNationality = body.getNationality();
		String newStatus = body.getStatus();
		authorService.updateAuthor(authId, newName, newBirthday, newNationality, newStatus);
	}

	@DeleteMapping(value = "/delete/{authId}/author")
	public void deleteAthourById(@PathVariable Long authId) {
		authorService.deleteAuthor(authId);
	}
}
