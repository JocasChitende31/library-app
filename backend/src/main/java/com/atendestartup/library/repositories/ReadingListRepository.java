package com.atendestartup.library.repositories;

import com.atendestartup.library.DTO.MyReadingListDTO;
import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.projections.ReadingListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<ReadingList, String> {

    @Modifying
    @Query(nativeQuery = true, value = """
        INSERT INTO tb_reading_lists (user_id, book_id) values(:user,:book)
    """)
   void insertIntoReadingList(String user, Long book);
    ReadingList findByBookId(Long id);
    @Query(nativeQuery = true, value = """
        SELECT 
        tb_reading_lists.id, 
        tb_reading_lists.user_id AS user, 
        tb_users.login, 
        tb_reading_lists.book_id AS book, 
        tb_books.title,
        tb_books.img_url AS imgUrl
        FROM 
        tb_reading_lists
        INNER JOIN  
        tb_users ON tb_reading_lists.user_id = tb_users.id 
        INNER JOIN 
        tb_books ON tb_reading_lists.book_id = tb_books.id 
        WHERE tb_reading_lists.user_id = :userId
    """)
    List<ReadingListProjection> findMyReadingList(String userId);
}
