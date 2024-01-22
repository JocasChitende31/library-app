package com.atendestartup.library.repositories;

import com.atendestartup.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String login);
    @Modifying
    @Query(nativeQuery = true, value = """
            	UPDATE tb_users SET login =:newLogin, password =:newPassword, role =:newRole WHERE id =:id
            """)
    void update(String id, String newLogin, String newPassword, String newRole);
}
