package com.atendestartup.library.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category fkCategory;
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Author fkAuthor;

	public Book() {

	}

	public Book(Long id, String title, String year, String publisher, Integer edition, String imgUrl,
			String shortSummary, String longSummary, Category category, Author author) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.publisher = publisher;
		this.edition = edition;
		this.imgUrl = imgUrl;
		this.shortSummary = shortSummary;
		this.longSummary = longSummary;
		fkCategory = category;
		fkAuthor = author;
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

	public Category getFkCategory() {
		return fkCategory;
	}

	public void setFkCategory(Category id) {
		this.fkCategory = id;
	}

	public Author getFkAuthor() {
		return fkAuthor;
	}

	public void setFkAuthor(Author id) {
		this.fkAuthor = id;
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
