package com.atendestartup.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.services.ReadingListService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;
    @PostMapping(value = "/add-reading-list")
    public ResponseEntity addToReadingList(@RequestBody @Valid ReadingList body){
        /* String id = body.getId();
        String user = body.getUser();
        Long book = body.getBook(); */
     this.readingListService.addBook(body);
     return ResponseEntity.ok("Adicionad a lista com sucesso!");
    }

}
