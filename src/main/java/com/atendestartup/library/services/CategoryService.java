package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendestartup.library.DTO.CategoryDTO;
import com.atendestartup.library.entities.Category;
import com.atendestartup.library.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryDTO> findAll() {
		List<Category> result = categoryRepository.findAll();
		List<CategoryDTO> dto = result.stream().map(x -> new CategoryDTO(x)).toList();
		return dto;
	}

}
