package com.atendestartup.library.DTO;

import com.atendestartup.library.entities.Category;

public class CategoryDTO {

	private Long id;
	private String genre;

	public CategoryDTO() {

	}

	public CategoryDTO(Category entity) {
		id = entity.getId();
		genre = entity.getGenre();
	}

	public Long getId() {
		return id;
	}

	public String getGenre() {
		return genre;
	}
}
