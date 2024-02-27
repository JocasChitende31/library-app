package com.atendestartup.library.controllers;

import com.atendestartup.library.DTO.ReadingListDTO;
import com.atendestartup.library.entities.User;
import com.atendestartup.library.services.ReadingListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;
    @PostMapping(value = "/add-reading-list")
    public ResponseEntity addToReadingList(@RequestBody @Valid ReadingListDTO body){
        String id = body.getId();
        String user = body.getUser();
        Long book = body.getBook();
     this.readingListService.addBook(user,book);
     return ResponseEntity.ok("Adicionad a lista com sucesso!");
    }

}
