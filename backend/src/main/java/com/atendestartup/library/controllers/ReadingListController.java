package com.atendestartup.library.controllers;

import com.atendestartup.library.DTO.MyReadingListDTO;
import com.atendestartup.library.DTO.ReadingListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.services.ReadingListService;

import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;
    @PostMapping(value = "/add-reading-list")
    public ResponseEntity addToReadingList(@RequestBody @Valid ReadingListDTO body){
        /* String id = body.getId();
        String user = body.getUser();
        Long book = body.getBook(); */
        if(this.readingListService.findByBookId(body.getBook().getId()) != null)
            return ResponseEntity.badRequest().body("Already exist on the list!");
        else
            this.readingListService.addBook(body);
        return ResponseEntity.ok("Book added successfully!");
    }
    @GetMapping(value = "/reading-list")
    public ResponseEntity findAll(){
        List<ReadingListDTO> data = this.readingListService.findAll();
        return ResponseEntity.ok(data);
    }
    @GetMapping(value = "my-reading-list/{userId}")
    public ResponseEntity findMyReadingList(@PathVariable String userId){
        List<MyReadingListDTO> data = this.readingListService.findMyReadingList(userId);
        if(!data.isEmpty())
            return ResponseEntity.ok(data);
        else
            return ResponseEntity.notFound().build();
    }

}
