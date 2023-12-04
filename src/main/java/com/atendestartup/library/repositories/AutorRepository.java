package com.atendestartup.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.atendestartup.library.entities.Author;

public interface AutorRepository extends JpaRepository<Author, Long> {

	@Modifying
	@Query(nativeQuery = true, value = """
			INSERT INTO tb_authors (name, birthday, nationality) values(:name, :birthday, :nationality)
			""")
	void insertAuthor(String name, String birthday, String nationality);
	@Modifying
	@Query(nativeQuery=true, value="""
			UPDATE tb_authors SET name = :newName, birthday = :newBirthday, nationality = :newNationality
			WHERE tb_authors.id = :authId """)
	void updateAuthor(Long authId, String newName, String newBirthday, String newNationality);
}
