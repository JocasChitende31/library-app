package com.atendestartup.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.atendestartup.library.projections.BookMinProjection;
import com.atendestartup.library.projections.BookProjection;
import com.atendestartup.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(nativeQuery = true, value = """
	SELECT * FROM tb_books WHERE tb_books.title = :title
	""")
	Book findBookByTitle(String title);
	@Query(nativeQuery = true, value = """
			SELECT
			tb_books.id AS id,
			tb_books.title,
			tb_books.book_year AS bookYear,
			tb_books.publisher AS publisher,
			tb_books.edition,
			tb_books.img_url AS imgUrl,
			tb_books.short_summary AS shortSummary,
			tb_books.category_id AS fkCategory,
			tb_category.genre,
			tb_books.author_id AS fkAuthor,
			tb_authors.name,
			tb_authors.nationality
			FROM
			tb_books
			INNER JOIN
			tb_category ON tb_books.category_id = tb_category.id
			INNER JOIN
			tb_authors ON tb_books.author_id = tb_authors.id
			ORDER BY tb_books.title ASC
			""")
	List<BookMinProjection> findMinListBook();

	@Query(nativeQuery = true, value = """
			SELECT
				tb_books.id,
				tb_books.title,
				tb_books.book_year AS bookYear,
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
				tb_authors.nationality,
				tb_authors.status
				FROM 
				tb_books
				INNER JOIN
				tb_category ON tb_books.category_id = tb_category.id
				INNER JOIN
				tb_authors ON tb_books.author_id = tb_authors.id
				WHERE tb_books.id = :bookId
				
				""")
	BookProjection searchById(Long bookId);

	@Query(nativeQuery = true, value = """
			SELECT
				tb_books.id,
				tb_books.title,
				tb_books.book_year AS bookYear,
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
				tb_authors.nationality,
				tb_authors.status
				FROM tb_books
				INNER JOIN
				tb_category ON tb_books.category_id = tb_category.id
				INNER JOIN
				tb_authors ON tb_books.author_id = tb_authors.id
				INNER JOIN
				tb_belonging ON tb_books.id = tb_belonging.book_id
				WHERE tb_belonging.category_id = :catId
				ORDER BY tb_belonging.position

						""")
	List<BookMinProjection> searchByCategoryId(Long catId);

	@Modifying
	@Query(nativeQuery = true, value = """
			INSERT INTO tb_books (title, book_year, publisher, edition, img_url, short_summary, long_summary, category_id, author_id) values(:title, :book_year, :publisher, :edition, :img_url, :short_summary, :long_summary, :categoryId, :authorId)
			""")
	void insertBook(String title, String book_year, String publisher, Integer edition, String img_url,
			String short_summary, String long_summary, Long categoryId, Long authorId);

	@Modifying
	@Query(nativeQuery = true, value = """
			UPDATE tb_books SET title = :newTitle, book_year = :newBook_year, publisher = :newPublisher, edition = :newEdition, img_url = :newImg_url, short_summary = :newShort_summary, long_summary = :newLong_summary, category_id = :newCategory_id, author_id = :newAuthor_id
			WHERE tb_books.id = :bookId""")
	void updateBook(Long bookId, String newTitle, String newBook_year, String newPublisher, Integer newEdition,
			String newImg_url, String newShort_summary, String newLong_summary, Long newCategory_id, Long newAuthor_id);
	
	@Modifying
	@Query(nativeQuery=true, value ="""
			DELETE FROM tb_books WHERE tb_books.id = :bookId
			"""
			)
	void deleteBook(Long bookId);
}
