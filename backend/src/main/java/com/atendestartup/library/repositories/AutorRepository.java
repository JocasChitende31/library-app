package com.atendestartup.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.atendestartup.labrary.projections.AuthorProjection;
import com.atendestartup.library.entities.Author;

public interface AutorRepository extends JpaRepository<Author, Long> {

	@Query(nativeQuery = true, value = """
			SELECT * FROM tb_authors
			ORDER BY tb_authors.name ASC
			""")
	List<AuthorProjection> findListAuthor();

	@Modifying
	@Query(nativeQuery = true, value = """
			INSERT INTO tb_authors (name, birthday, nationality, status) values(:name, :birthday, :nationality, :status)
			""")
	void insertAuthor(String name, String birthday, String nationality, String status);

	@Modifying
	@Query(nativeQuery = true, value = """
			UPDATE tb_authors SET name = :newName, birthday = :newBirthday, nationality = :newNationality, status = :newStatus
			WHERE tb_authors.id = :authId """)
	void updateAuthor(Long authId, String newName, String newBirthday, String newNationality, String newStatus);
}
