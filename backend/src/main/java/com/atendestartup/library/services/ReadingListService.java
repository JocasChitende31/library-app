package com.atendestartup.library.services;

import com.atendestartup.library.repositories.ReadingListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Transactional
    public void addBook(String user_id, Long book_id){
        this.readingListRepository.insertIntoReadingList(user_id, book_id);
    }

}
