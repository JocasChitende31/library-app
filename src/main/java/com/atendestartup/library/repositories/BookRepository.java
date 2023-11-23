package com.atendestartup.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atendestartup.labrary.projections.BookMinProjection;
import com.atendestartup.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(nativeQuery=true, value="""
			SELECT 
			tb_books.id,
			tb_books.title,
			tb_books.book_year AS booKYear,
			tb_books.publisher AS publisher,
			tb_books.genre,
			tb_books.edition,
			tb_books.short_summary AS shortSummary,
			tb_books.fk_author AS fkAuthor,
			tb_authors.name, tb_authors.nationality FROM tb_books
			INNER JOIN 
			tb_authors ON tb_books.fk_author = tb_authors.id 
			"""
			)
	List<BookMinProjection> findMinListBook();
}
