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

import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.DTO.CategoryDTO;
import com.atendestartup.library.DTO.ReplacementDTO;
import com.atendestartup.library.entities.Category;
import com.atendestartup.library.services.BookService;
import com.atendestartup.library.services.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BookService bookService;

	@GetMapping(value="/categories")
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> result = categoryService.findAll();
		return result;
	}

	@GetMapping(value = "/{catId}/category")
	public CategoryDTO findCategoryById(@PathVariable Long catId) {
		CategoryDTO result = categoryService.findCategoryById(catId);
		return result;
	}

	@GetMapping(value = "/{catId}/books")
	public List<BookMinDTO> findBookListByCategoryId(@PathVariable Long catId) {
		List<BookMinDTO> result = bookService.findByListCategoryId(catId);
		return result;
	}

	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		categoryService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}

	@PostMapping(value = "/create/category")
	public void insertCategory(@RequestBody Category body) {
		 categoryService.createCategory(body);
	}

	@PutMapping(value = "/update/{catId}/category")
	public void update(@PathVariable Long catId, @RequestBody CategoryDTO body) {
		String genre = body.getGenre();
		categoryService.updateCategory(catId, genre);
	}

	@DeleteMapping(value = "/delete/{catId}/category")
	public void delete(@PathVariable Long catId) {
		 categoryService.deleteCategoryById(catId);
		
		
	}

}
