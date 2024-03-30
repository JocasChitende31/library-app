package com.atendestartup.library.services;

import com.atendestartup.library.DTO.MyReadingListDTO;
import com.atendestartup.library.DTO.ReadingListDTO;
import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.projections.ReadingListProjection;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendestartup.library.repositories.ReadingListRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Transactional
    public void addBook(@Valid ReadingListDTO body){
        ReadingList data = new ReadingList(body.getId(), body.getUser(), body.getBook());
        System.out.println(data);
        this.readingListRepository.save(data);
    }
    @Transactional
    public ReadingList findByBookId(Long id){
        ReadingList data = this.readingListRepository.findByBookId(id);
        return data;
    }
    @Transactional
    public List<ReadingListDTO> findAll(){
        List<ReadingList> resul = this.readingListRepository.findAll();
        List<ReadingListDTO> dto = resul.stream().map(x -> new ReadingListDTO(x)).toList();
        return dto;
    }
    @Transactional
    public List<MyReadingListDTO> findMyReadingList(String id){
        List<ReadingListProjection> resul  = this.readingListRepository.findMyReadingList(id);
        List<MyReadingListDTO> dto = resul.stream().map(x -> new MyReadingListDTO(x)).toList();
        return dto;
    }
}
