package com.atendestartup.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendestartup.library.DTO.AuthenticationDTO;
import com.atendestartup.library.DTO.LoginResponseDTO;
import com.atendestartup.library.DTO.RegisterDTO;
import com.atendestartup.library.entities.User;
import com.atendestartup.library.infraSecurity.TokenService;
import com.atendestartup.library.services.AuthorizationService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO body) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(body.login(), body.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO body) {
        if (authorizationService.loadUserByUsername(body.login()) != null)
            return ResponseEntity.badRequest().build();
        else
            this.authorizationService.register(body);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value="/search-user/{login}")
    public ResponseEntity serachUserById(@PathVariable @Valid String login) {
    	RegisterDTO data = this.authorizationService.findByLoginName(login);
    	return ResponseEntity.ok(data);
    	
    }
    @GetMapping(value = "/users")
    public ResponseEntity findAll(){
        List<RegisterDTO> data = this.authorizationService.findAll();
        return ResponseEntity.ok(data);
    }
    @GetMapping(value = "/user/{login}")
    public ResponseEntity findByName(@PathVariable @Valid String login){
        UserDetails data = this.authorizationService.loadUserByUsername(login);
        return  ResponseEntity.ok(data);
    }
    @PutMapping(value = "/user/{id}/update")
    public ResponseEntity update(@PathVariable String id, @RequestBody @Valid RegisterDTO body){
        this.authorizationService.update(id, body);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/user/{id}/delete")
    public ResponseEntity delete(@PathVariable String id){
        this.authorizationService.delete(id);
        return ResponseEntity.ok().build();
    }

}
