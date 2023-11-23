package com.atendestartup.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.services.BookService;

@RestController
@RequestMapping(value = "/books/min/list")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<BookMinDTO> findMinList() {

		List<BookMinDTO> result = bookService.findMinListBook();
		return result;
	}
}
