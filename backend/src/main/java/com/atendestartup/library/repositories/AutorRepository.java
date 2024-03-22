package com.atendestartup.library.repositories;

import com.atendestartup.library.entities.Author;
import com.atendestartup.library.projections.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Author, Long> {


    @Query(nativeQuery = true, value = """
            	SELECT * FROM tb_authors WHERE tb_authors.name = :name
            """)
    Author findByName(String name);
    @Query(nativeQuery = true, value = """
            SELECT * FROM tb_authors
            ORDER BY tb_authors.name ASC
            """)
    List<AuthorProjection> findListAuthor();

    @Modifying
    @Query(nativeQuery = true, value = """
            UPDATE tb_authors SET name = :newName, birthday = :newBirthday, nationality = :newNationality, status = :newStatus
            WHERE tb_authors.id = :authId """)
    void updateAuthor(Long authId, String newName, String newBirthday, String newNationality, String newStatus);
}
