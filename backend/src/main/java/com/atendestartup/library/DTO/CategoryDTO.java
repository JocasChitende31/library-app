package com.atendestartup.library.DTO;

import com.atendestartup.labrary.projections.CategoryProjection;
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
	public CategoryDTO(CategoryProjection projection) {
		id = projection.getId();
		genre = projection.getGenre();
	}

	public Long getId() {
		return id;
	}

	public String getGenre() {
		return genre;
	}
}
