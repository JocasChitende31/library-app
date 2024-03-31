package com.atendestartup.library.entities;


import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_reading_lists")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadingList {
	
//	public static final long SerialVersionUID = 8703616441477399287L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Basic(optional=false)
    @Column(name="id")
	private String id = UUID.randomUUID().toString();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NotNull
    private User user;

    //@ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "book_id", referencedColumnName = "id")
    //@JsonDeserialize()
    @Column(name="book_id")
    @NotNull
    private Long book;


    public ReadingList(){

    }

    @JsonCreator
    public ReadingList(String id, User user, Long book){
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public User getFkUser(){
        return  this.user;
    }
    public void setFkUser(User user){
        this.user = user;
    }
    public Long getFkBook(){
        return  this.book;
    }
    public void setFkBook(Long book){
        this.book = book;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id,this.user);
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReadingList other = (ReadingList) obj;
        //return  Objects.equals(this.id, other.id) && Objects.equals(this.user, other.user) && Objects.equals(this.book, other.book);
        return  Objects.equals(this.id, other.id) && Objects.equals(this.user, other.user);
    }
}
