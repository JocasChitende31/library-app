package com.atendestartup.library.DTO;

import com.atendestartup.library.projections.BookMinProjection;
import com.atendestartup.library.entities.Book;

public class BookMinDTO {

	private Long id;
	private String title;
	private String year;
	private String publisher;
	private Integer edition;
	private String imgUrl;
	private String shortSummary;
	private Long fkCategory;
	private String genre;
	private Long fkAuthor;
	private String name;
	private String nationality;

	private String downloaderRefPDF;

	public BookMinDTO() {

	}

	public BookMinDTO(Book entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getBookYear();
		publisher = entity.getPublisher();
		edition = entity.getEdition();
		imgUrl = entity.getImgUrl();
		shortSummary = entity.getLongSummary();
		downloaderRefPDF = entity.getDownloaderRefPDF();
	}

	public BookMinDTO(BookMinProjection projection) {

		id = projection.getId();
		title = projection.getTitle();
		year = projection.getBookYear();
		publisher = projection.getPublisher();
		edition = projection.getEdition();
		imgUrl = projection.getImgUrl();
		shortSummary = projection.getShortSummary();
		fkCategory = projection.getFkCategory();
		genre = projection.getGenre();
		fkAuthor = projection.getFkAuthor();
		name = projection.getName();
		nationality = projection.getNationality();
		downloaderRefPDF = projection.getDownloaderRefPDF();
	}

	public Long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getBookYear() {
		return this.year;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public Integer getEdition() {
		return this.edition;
	}
	public String getImgUrl() {
		return this.imgUrl;
	}
	public String getShortSummary() {
		return this.shortSummary;
	}

	public Long getFkCategory() {
		return this.fkCategory;
	}

	public String getGenre() {
		return this.genre;
	}

	public Long getFkAuthor() {
		return this.fkAuthor;
	}

	public String getName() {
		return this.name;
	}

	public String getNationality() {
		return this.nationality;
	}

	public String getDownloaderRefPDF(){
		return this.downloaderRefPDF;
	}
}
