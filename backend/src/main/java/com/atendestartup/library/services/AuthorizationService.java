package com.atendestartup.library.services;

import com.atendestartup.library.DTO.RegisterDTO;
import com.atendestartup.library.entities.User;
import com.atendestartup.library.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return userRepository.findByLogin(username);

    }

    @Transactional
    public void register(RegisterDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.id(), data.login(), encryptedPassword, data.role());
        this.userRepository.save(newUser);
    }

    @Transactional
    public List<RegisterDTO> findAll() {
        List<User> listUser = this.userRepository.findAll();
        List<RegisterDTO> data = listUser.stream().map(x -> new RegisterDTO(x.getId(), x.getLogin(), x.getPassword(), x.getRole())).toList();
        return data;
    }

    @Transactional
    public void update(String id, RegisterDTO body) {
        String newLogin = body.login();
        String newEncryptedPassword = new BCryptPasswordEncoder().encode(body.password());
        String newRole = body.role().toString();
        this.userRepository.update(id, newLogin, newEncryptedPassword, newRole);
    }

    @Transactional
    public void delete(String id) {
        User user = this.userRepository.findById(id).get();
        this.userRepository.delete(user);
    }
}
