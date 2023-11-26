package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atendestartup.labrary.projections.BookMinProjection;
import com.atendestartup.labrary.projections.BookProjection;
import com.atendestartup.library.DTO.BookDTO;
import com.atendestartup.library.DTO.BookMinDTO;
import com.atendestartup.library.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Transactional(readOnly=true)
	public 	BookDTO findById(Long id) {
		BookProjection result = bookRepository.searchById(id);
		BookDTO dto = new BookDTO(result);
		return dto;
	}
	
	@Transactional(readOnly=true)
	public List<BookMinDTO> findMinListBook(){
		List<BookMinProjection> result = bookRepository.findMinListBook();
		List<BookMinDTO> dto = result.stream().map(x -> new BookMinDTO(x)).toList();
		return dto;
	}
	
}
