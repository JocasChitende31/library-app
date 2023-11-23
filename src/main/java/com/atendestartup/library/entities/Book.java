package com.atendestartup.library.entities;

public class Book {

	private Long id;
	private String title;
	private String year;
	private Integer edition;
	private String shortSummary;
	private String longSummary;

	public Book() {

	}

	public Book(Long id, String title, String year, Integer edition, String shortSummary, String longSummary) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.edition = edition;
		this.shortSummary = shortSummary;
		this.longSummary = longSummary;
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
}
