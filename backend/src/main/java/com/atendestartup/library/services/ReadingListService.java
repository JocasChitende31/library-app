package com.atendestartup.library.services;

import com.atendestartup.library.DTO.ReadingListDTO;
import com.atendestartup.library.entities.ReadingList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendestartup.library.repositories.ReadingListRepository;

import jakarta.transaction.Transactional;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Transactional
    public void addBook(@Valid ReadingListDTO body){
        ReadingList data = new ReadingList(body.getId(),body.getUser(), body.getBook());
        this.readingListRepository.save(data);
    }

}
