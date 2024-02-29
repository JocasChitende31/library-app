package com.atendestartup.library.repositories;

import com.atendestartup.library.entities.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReadingListRepository extends JpaRepository<ReadingList, String> {

    @Modifying
    @Query(nativeQuery = true, value = """
        INSERT INTO tb_reading_lists (user_id, book_id) values(:user,:book)
    """)
   void insertIntoReadingList(String user, Long book);
    ReadingList findByBookId(Long id);
}
