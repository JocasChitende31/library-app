package com.atendestartup.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atendestartup.labrary.projections.BookMinProjection;
import com.atendestartup.labrary.projections.CategoryProjection;
import com.atendestartup.library.DTO.CategoryDTO;
import com.atendestartup.library.entities.Category;
import com.atendestartup.library.repositories.BookRepository;
import com.atendestartup.library.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<CategoryProjection> result = categoryRepository.findListCategory();
		List<CategoryDTO> dto = result.stream().map(x -> new CategoryDTO(x)).toList();
		return dto;
	}

	@Transactional
	public CategoryDTO findCategoryById(Long catId) {
		CategoryProjection result = categoryRepository.findCategoryById(catId);
		CategoryDTO dto = new CategoryDTO(result);
		return dto;
	}

	@Transactional
	public void move(Long catId, int sourceIndex, int destinationIndex) {
		List<BookMinProjection> list = bookRepository.searchByCategoryId(catId);
		BookMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			categoryRepository.updateBelogingPosition(catId, list.get(i).getId(), i);
		}
	}

	@Transactional
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	@Transactional
	public void updateCategory(Long id, String genre) {
		categoryRepository.updateCategory(id, genre);
	}

	@Transactional
	public void deleteCategoryById(Long catId) {
		categoryRepository.deleteCategoryById(catId);
	}

}
