package com.atendestartup.library.controllers;

import com.atendestartup.library.DTO.AuthenticationDTO;
import com.atendestartup.library.DTO.RegisterDTO;
import com.atendestartup.library.services.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO body) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(body.login(), body.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO body) {
        if (authorizationService.loadUserByUsername(body.login()) != null)
            return ResponseEntity.badRequest().build();
        else
            this.authorizationService.register(body);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/users")
    public ResponseEntity findAll(){
        List<RegisterDTO> data = this.authorizationService.findAll();
        return ResponseEntity.ok(data);

    }

}
