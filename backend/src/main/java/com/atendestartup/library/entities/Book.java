package com.atendestartup.library.entities;

import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id")
	private Long id;
	private String title;
	@Column(name = "book_year")
	private String year;
	private String publisher;
	private Integer edition;
	private String imgUrl;
	@Column(columnDefinition = "TEXT")
	private String shortSummary;
	@Column(columnDefinition = "TEXT")
	private String longSummary;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category fkCategory;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author fkAuthor;
	@Column(name="downloader_ref_pdf")
	private String downloaderRefPDF;

	public Book() {

	}

	public Book(Long id, String title, String year, String publisher, Integer edition, String imgUrl,
			String shortSummary, String longSummary, Category category, Author author, String downloaderRefPDF) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.publisher = publisher;
		this.edition = edition;
		this.imgUrl = imgUrl;
		this.shortSummary = shortSummary;
		this.longSummary = longSummary;
		this.fkCategory = category;
		this.fkAuthor = author;
		this.downloaderRefPDF = downloaderRefPDF;
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

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public Category getCategoryId() {
		return fkCategory;
	}

	public void setCategoryId(Category id) {
		this.fkCategory = id;
	}

	public Author getAuthorId() {
		return fkAuthor;
	}

	public void setAuthorId(Author id) {
		this.fkAuthor = id;
	}

	public String getDownloaderRefPDF(){
		return this.downloaderRefPDF;
	}
	public void setDownloaderRefPDF(String downloaderRefPDF){
		this.downloaderRefPDF = downloaderRefPDF;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkAuthor, fkCategory, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(fkAuthor, other.fkAuthor) && Objects.equals(fkCategory, other.fkCategory)
				&& Objects.equals(id, other.id);
	}

}
