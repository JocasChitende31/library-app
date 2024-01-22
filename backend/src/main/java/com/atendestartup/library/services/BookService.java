package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atendestartup.library.projections.BookMinProjection;
import com.atendestartup.library.projections.BookProjection;
import com.atendestartup.library.DTO.BookDTO;
import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Transactional(readOnly = true)
	public BookDTO findById(Long id) {
		BookProjection result = bookRepository.searchById(id);
		BookDTO dto = new BookDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<BookMinDTO> findMinListBook() {
		List<BookMinProjection> result = bookRepository.findMinListBook();
		List<BookMinDTO> dto = result.stream().map(x -> new BookMinDTO(x)).toList();
		return dto;
	}

	@Transactional(readOnly = true)
	public List<BookMinDTO> findByListCategoryId(Long id) {
		List<BookMinProjection> result = bookRepository.searchByCategoryId(id);
		List<BookMinDTO> dto = result.stream().map(x -> new BookMinDTO(x)).toList();
		return dto;
	}

	@Transactional
	public void createBook(String title, String book_year, String publisher, Integer edition, String img_url,
			String short_summary, String long_summary, Long categoryId, Long authorId) {
		bookRepository.insertBook(title, book_year, publisher, edition, img_url, short_summary, long_summary,
				categoryId, authorId);

	}

	@Transactional
	public void updateBook(Long bookId, String title, String book_year, String publisher, Integer edition, String img_url,
			String short_summary, String long_summary, Long categoryId, Long authorId) {
		bookRepository.updateBook(bookId, title, book_year, publisher, edition, img_url, short_summary, long_summary, categoryId, authorId);
	}
	@Transactional 
	public void deleteBook(Long bookId) {
		bookRepository.deleteBook(bookId);
	}
}
