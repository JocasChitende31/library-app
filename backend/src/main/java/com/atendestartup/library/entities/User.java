package com.atendestartup.library.entities;

import java.util.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.atendestartup.library.enums.UserRole;


@Entity
@Table(name = "tb_users")
public class User implements UserDetails {

	private static final long serialVersionUID = 8703616441477399287L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id = UUID.randomUUID().toString();

	@Column(unique = true)
	private String login;

	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	@OneToMany(mappedBy = "user")
	private List<ReadingList> readingList;
	public User() {
	}

	public User(String id, String login, String password, UserRole role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return this.role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public int hashCode() {
		return Objects.hash(this.id);
	}
	public List<ReadingList> getReadingList(){
		return this.readingList;
	}
	public void setReadingList(List<ReadingList> readingList){
		this.readingList = readingList;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		User other = (User)obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
