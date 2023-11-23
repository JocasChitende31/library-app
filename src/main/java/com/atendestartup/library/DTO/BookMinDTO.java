package com.atendestartup.library.DTO;

import com.atendestartup.labrary.projections.BookMinProjection;
import com.atendestartup.library.entities.Book;

public class BookMinDTO {

	private Long id;
	private String title;
	private String year;
	private String publisher;
	private Integer edition;
	private String genre;
	private String shortSummary;
	private Long fkAuthor;
	private String name;
	private String nationality;

	public BookMinDTO() {

	}

	public BookMinDTO(Book entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		publisher = entity.getPublisher();
		edition = entity.getEdition();
		genre = entity.getGenre();
		shortSummary = entity.getLongSummary();
		fkAuthor = entity.getFkAuthor();
	}

	public BookMinDTO(BookMinProjection projection) {

		id = projection.getId();
		title = projection.getTitle();
		year = projection.getBookYear();
		publisher = projection.getPublisher();
		genre = projection.getGenre();
		edition = projection.getEdition();
		shortSummary = projection.getShortSummary();
		fkAuthor = projection.getFkAuthor();
		name = projection.getName();
		nationality = projection.getNationality();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getGenre() {
		return genre;
	}

	public Integer getEdition() {
		return edition;
	}

	public String getShortSummary() {
		return shortSummary;
	}

	public Long getFkAuthor() {
		return fkAuthor;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}
}
