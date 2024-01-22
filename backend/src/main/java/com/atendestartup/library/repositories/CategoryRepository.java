package com.atendestartup.library.repositories;

import com.atendestartup.library.DTO.CategoryDTO;
import com.atendestartup.library.entities.Category;
import com.atendestartup.library.projections.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_category.genre FROM tb_category WHRE genre = :genre
                        """)
    CategoryDTO findByGenre(String genre);
    @Query(nativeQuery = true, value = """
            SELECT * FROM tb_category 
            ORDER BY tb_category.genre ASC
            """)
    List<CategoryProjection> findListCategory();
    @Query(nativeQuery = true, value = """
            SELECT * FROM tb_category WHERE tb_category.id = :catId
            """)
    CategoryProjection findCategoryById(Long catId);
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE category_id=:catId AND book_id=:bookId")
    void updateBelogingPosition(Long catId, Long bookId, Integer newPosition);
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_category SET genre = :newGenre WHERE tb_category.id = :catId")
    void updateCategory(Long catId, String newGenre);
    @Modifying
    @Query(nativeQuery = true, value = """
            DELETE FROM tb_category WHERE tb_category.id = :catId
            """)
    void deleteCategoryById(Long catId);

}
