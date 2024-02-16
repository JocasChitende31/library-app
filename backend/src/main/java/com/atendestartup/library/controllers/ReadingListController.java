package com.atendestartup.library.controllers;

import com.atendestartup.library.DTO.ReadingListDTO;
import com.atendestartup.library.entities.User;
import com.atendestartup.library.services.ReadingListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;
    @PostMapping(value = "/add-reading-list")
    public ResponseEntity addToReadingList(@RequestBody @Valid ReadingListDTO body){
     this.readingListService.addBook(body);
     return ResponseEntity.ok().build();
    }

}
