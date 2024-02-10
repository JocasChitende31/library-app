package com.atendestartup.library.projections;

public interface BookMinProjection {

	Long getId();

	String getTitle();

	String getBookYear();

	String getPublisher();

	Integer getEdition();

	String getImgUrl();

	String getShortSummary();

	Long getFkCategory();

	String getGenre();

	Long getFkAuthor();

	String getName();

	String getNationality();
	String getDownloaderRefPDF();
}
