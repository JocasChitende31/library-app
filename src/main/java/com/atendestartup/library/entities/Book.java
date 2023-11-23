package com.atendestartup.library.entities;

import com.atendestartup.library.DTO.AuthorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Column(name = "book_year")
	private String year;
	private String publisher;
	private String genre;
	private Integer edition;
	@Column(columnDefinition = "TEXT")
	private String shortSummary;
	@Column(columnDefinition = "TEXT")
	private String longSummary;

	private Long fkAuthor;

	public Book() {

	}

	public Book(Long id, String title, String year, String publisher, Integer edition, String genre,
			String shortSummary, String longSummary, AuthorDTO entity) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.publisher = publisher;
		this.edition = edition;
		this.genre = genre;
		this.shortSummary = shortSummary;
		this.longSummary = longSummary;
		fkAuthor = entity.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getShortSummary() {
		return shortSummary;
	}

	public void setShortSummary(String shortSummary) {
		this.shortSummary = shortSummary;
	}

	public String getLongSummary() {
		return longSummary;
	}

	public void setLongSummary(String longSummary) {
		this.longSummary = longSummary;
	}

	public Long getFkAuthor() {
		return fkAuthor;
	}

	public void setFkAuthor(Long id) {
		this.fkAuthor = id;
	}
}
