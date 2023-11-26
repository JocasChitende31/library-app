package com.atendestartup.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.DTO.CategoryDTO;
import com.atendestartup.library.services.BookService;
import com.atendestartup.library.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BookService bookService;

	@GetMapping
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> result = categoryService.findAll();
		return result;
	}

	@GetMapping(value="/{catId}/books")
	public List<BookMinDTO> findBookListByCategoryId(@PathVariable Long catId) {
		List<BookMinDTO> result = bookService.findByListCategoryId(catId);
		return result;
	}
}
