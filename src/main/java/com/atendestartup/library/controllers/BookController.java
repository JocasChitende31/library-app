package com.atendestartup.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.library.DTO.BookDTO;
import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.services.BookService;

@RestController
@RequestMapping(value = "/books/min/list")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value="/{id}")
	public BookDTO findById(@PathVariable Long id) {
		BookDTO result = bookService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<BookMinDTO> findMinList() {

		List<BookMinDTO> result = bookService.findMinListBook();
		return result;
	}
}
