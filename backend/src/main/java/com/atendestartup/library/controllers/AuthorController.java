package com.atendestartup.library.controllers;

import com.atendestartup.library.DTO.AuthorDTO;
import com.atendestartup.library.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors")
    public List<AuthorDTO> findAll() {
        List<AuthorDTO> result = authorService.findAll();
        return result;
    }

    @GetMapping(value = "/{authId}/author")
    public AuthorDTO findAuthorById(@PathVariable Long authId) {
        AuthorDTO result = authorService.findById(authId);
        return result;
    }

    @PostMapping(value = "/create/author")
    public ResponseEntity createAuthor(@RequestBody @Valid AuthorDTO body) {
        if (this.authorService.findByName(body.name()) != null)
            return ResponseEntity.badRequest().build();
        else
            this.authorService.createAuthor(body);
            return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update/{authId}/author")
    public ResponseEntity updateAuthor(@PathVariable Long authId, @RequestBody @Valid AuthorDTO body) {
        this.authorService.updateAuthor(authId, body);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{authId}/author")
    public ResponseEntity deleteAthourById(@PathVariable Long authId) {
        this.authorService.deleteAuthor(authId);
        return ResponseEntity.ok().build();
    }
}
