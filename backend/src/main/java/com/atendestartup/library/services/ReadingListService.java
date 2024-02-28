package com.atendestartup.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.repositories.ReadingListRepository;

import jakarta.transaction.Transactional;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Transactional
    public void addBook(ReadingList body){
        this.readingListRepository.save(body);
    }

}
