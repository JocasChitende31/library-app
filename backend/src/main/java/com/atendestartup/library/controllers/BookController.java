package com.atendestartup.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atendestartup.library.DTO.BookDTO;
import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.services.BookService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value="/books")
	public List<BookMinDTO> findMinList() {
		List<BookMinDTO> result = bookService.findMinListBook();
		return result;
	}
	
	@GetMapping(value = "/{id}/book")
	public BookDTO findById(@PathVariable Long id) {
		BookDTO result = bookService.findById(id);
		return result;
	}

	@PostMapping("/create/book")
	public void createBook(@RequestBody BookDTO body) {
		String title = body.getTitle();
		String year = body.getBookYear();
		String publisher = body.getPublisher();
		Integer edition = body.getEdition();
		String imgUrl = body.getImgUrl();
		String shortSummary = body.getShortSummary();
		String longSummary = body.getLongSummary();
		Long categoryId = body.getFkCategory();
		Long authorId = body.getFkAuthor();
		bookService.createBook(title, year, publisher, edition, imgUrl, shortSummary, longSummary, categoryId,
				authorId);
	}

	@PutMapping(value = "/update/{bookId}/book")
	public void updateBook(@PathVariable Long bookId, @RequestBody BookDTO body) {
		String newTitle = body.getTitle();
		String newYear = body.getBookYear();
		String newPublisher = body.getPublisher();
		Integer newEdition = body.getEdition();
		String newImgUrl = body.getImgUrl();
		String newShortSummary = body.getShortSummary();
		String newLongSummary = body.getLongSummary();
		Long newCategoryId = body.getFkCategory();
		Long newAuthorId = body.getFkAuthor();
		bookService.updateBook(bookId, newTitle, newYear, newPublisher, newEdition, newImgUrl, newShortSummary,
				newLongSummary, newCategoryId, newAuthorId);
	}

	@DeleteMapping(value="/delete/{bookId}/book")
	public void deleteBook(@PathVariable Long bookId) {
		bookService.deleteBook(bookId);
	}
}
