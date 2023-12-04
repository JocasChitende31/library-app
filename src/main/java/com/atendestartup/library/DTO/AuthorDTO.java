package com.atendestartup.library.DTO;

import com.atendestartup.labrary.projections.AuthorProjection;
import com.atendestartup.library.entities.Author;

public class AuthorDTO {

	private Long id;
	private String name;
	private String birthday;
	private String nationality;

	public AuthorDTO() {

	}

	public AuthorDTO(Author entity) {
		id = entity.getId();
		name = entity.getName();
		birthday = entity.getBirthday();
		nationality = entity.getNationality();
	}
	public AuthorDTO(AuthorProjection projection) {
		id = projection.getId();
		name = projection.getName();
		birthday=projection.getBirthday();
		nationality = projection.getNationality();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getNationality() {
		return nationality;
	}
}
