package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendestartup.labrary.projections.BookMinProjection;
import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<BookMinDTO> findMinListBook(){
		List<BookMinProjection> result = bookRepository.findMinListBook();
		List<BookMinDTO> dto = result.stream().map(x -> new BookMinDTO(x)).toList();
		return dto;
	}
}
