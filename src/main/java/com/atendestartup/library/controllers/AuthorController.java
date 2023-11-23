package com.atendestartup.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.library.DTO.AuthorDTO;
import com.atendestartup.library.services.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public List<AuthorDTO> findAll() {
		List<AuthorDTO> result = authorService.findAll();
		return result;
	}
}
