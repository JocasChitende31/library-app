package com.atendestartup.labrary.projections;

public interface BookProjection {
	Long getId();

	String getTitle();

	String getBookYear();

	String getPublisher();

	Integer getEdition();

	String getImgUrl();

	String getShortSummary();
	
	String getLongSummary();

	Long getFkCategory();

	String getGenre();

	Long getFkAuthor();

	String getName();
	
	String getBirthday();

	String getNationality();
	
	String getStatus();
}
