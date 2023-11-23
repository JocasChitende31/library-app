package com.atendestartup.labrary.projections;

public interface BookMinProjection {

	Long getId();

	String getTitle();

	String getBookYear();

	String getPublisher();

	String getGenre();

	Integer getEdition();

	String getShortSummary();

	Long getFkAuthor();

	String getName();

	String getNationality();
}
