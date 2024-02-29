package com.atendestartup.library.entities;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_reading_lists")
public class ReadingList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Basic(optional=false)
    @Column(name="id")
    private String id = UUID.randomUUID().toString();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NotNull
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @NotNull
    private Book book;

    public ReadingList(){

    }

    @JsonCreator
    public ReadingList(String id, User user, Book book){
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
    public Book getFkBook(){
        return  this.book;
    }
    public void setFkBook(Book book){
        this.book = book;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id,this.book, this.book);
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
        return  Objects.equals(this.id, other.id) && Objects.equals(this.user, other.user) && Objects.equals(this.book, other.book);
    }
}
