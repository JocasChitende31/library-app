package com.atendestartup.library.DTO;

import org.springframework.beans.BeanUtils;

import com.atendestartup.labrary.projections.BookProjection;
import com.atendestartup.library.entities.Book;

public class BookDTO {

	private Long id;
	private String title;
	private String year;
	private String publisher;
	private Integer edition;
	private String imgUrl;
	private Long fkCategory;
	private String genre;
	private String shortSummary;
	private String longSummary;
	private Long fkAuthor;
	private String name;
	private String birthday;
	private String nationality;
	private String status;

	public BookDTO() {

	}

	public BookDTO(Book entity) {

		BeanUtils.copyProperties(entity, this);
	}

	public BookDTO(BookProjection projection) {

		id = projection.getId();
		title = projection.getTitle();
		year = projection.getBookYear();
		publisher = projection.getPublisher();
		edition = projection.getEdition();
		imgUrl = projection.getImgUrl();
		fkCategory = projection.getFkCategory();
		genre = projection.getGenre();
		shortSummary = projection.getShortSummary();
		longSummary = projection.getLongSummary();
		fkAuthor = projection.getFkAuthor();
		name = projection.getName();
		birthday = projection.getBirthday();
		nationality = projection.getNationality();
		status = projection.getStatus();
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

	public String getBookYear() {
		return year;
	}

	public void setBookYear(String year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEditon(Integer edition) {
		this.edition = edition;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getFkCategory() {
		return fkCategory;
	}

	public void getFkCategory(Long fkCategory) {
		this.fkCategory = fkCategory;
	}

	public String getGenre() {
		return genre;
	}

	public String getShortSummary() {
		return shortSummary;
	}

	public void shortSummary(String shortSummary) {
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

	public void setFkAuthor(Long fkAuthor) {
		this.fkAuthor = fkAuthor;
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
