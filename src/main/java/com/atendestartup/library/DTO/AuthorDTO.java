package com.atendestartup.library.DTO;

import com.atendestartup.labrary.projections.AuthorProjection;
import com.atendestartup.library.entities.Author;

public class AuthorDTO {

	private Long id;
	private String name;
	private String birthday;
	private String nationality;
	private String status;

	public AuthorDTO() {

	}

	public AuthorDTO(Author entity) {
		id = entity.getId();
		name = entity.getName();
		birthday = entity.getBirthday();
		nationality = entity.getNationality();
		status = entity.getStatus();
	}

	public AuthorDTO(AuthorProjection projection) {
		id = projection.getId();
		name = projection.getName();
		birthday = projection.getBirthday();
		nationality = projection.getNationality();
		status = projection.getStatus();
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

	public String getStatus() {
		return status;
	}
}
