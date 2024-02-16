package com.atendestartup.library.services;

import com.atendestartup.library.DTO.ReadingListDTO;
import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.repositories.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    public ReadingList getExistItem(Long idItem){
       return this.readingListRepository.getExistItem(idItem);
    }
    public void addBook(ReadingListDTO body){
        ReadingList newBook = new ReadingList(body.id(), body.fkUser(), body.fkBook());
        this.readingListRepository.save(newBook);
    }

}
