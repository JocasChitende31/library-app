package com.atendestartup.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atendestartup.labrary.projections.BookMinProjection;
import com.atendestartup.labrary.projections.BookProjection;
import com.atendestartup.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(nativeQuery = true, value = """
			SELECT
			tb_books.id,
			tb_books.title,
			tb_books.book_year AS booKYear,
			tb_books.publisher AS publisher,
			tb_books.edition,
			tb_books.img_url AS imgUrl,
			tb_books.short_summary AS shortSummary,
			tb_books.category_id AS fkCategory,
			tb_category.genre,
			tb_books.author_id AS fkAuthor,
			tb_authors.id,
			tb_authors.name,
			tb_authors.nationality
			FROM
			tb_books
			         INNER JOIN
			         tb_category ON tb_books.category_id = tb_category.id
			INNER JOIN
			tb_authors ON tb_books.author_id = tb_authors.id
			""")
	List<BookMinProjection> findMinListBook();

	@Query(nativeQuery = true, value = """
		SELECT
			tb_books.id,
			tb_books.title,
			tb_books.book_year AS booKYear,
			tb_books.publisher AS publisher,
			tb_books.edition,
			tb_books.img_url AS imgUrl,
			tb_books.short_summary AS shortSummary,
			tb_books.long_summary AS longSummary,
			tb_books.category_id AS fkCategory,
			tb_category.genre,
			tb_books.author_id AS fkAuthor,
			tb_authors.name, 
			tb_authors.birthday, 
			tb_authors.nationality
			FROM tb_books
			         INNER
			         JOIN
			         tb_category ON tb_books.category_id = tb_category.id
			INNER JOIN
			tb_authors ON tb_books.author_id = tb_authors.id
			WHERE tb_books.id = :listId
			""")
	BookProjection searchById(Long listId);
}
