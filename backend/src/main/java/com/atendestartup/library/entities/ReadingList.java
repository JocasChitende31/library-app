package com.atendestartup.library.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_reading_lists")
public class ReadingList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id = UUID.randomUUID().toString();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User fkUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book fkBook;

    public ReadingList(){

    }
    public ReadingList(String id, User fkUser, Book fkBook){
        this.id = id;
        this.fkUser = fkUser;
        this.fkBook = fkBook;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getFkUser(){
        return  this.fkUser;
    }
    public void setFkUser(User fkUser){
        this.fkUser = fkUser;
    }
    public Book getFkBook(){
        return  this.fkBook;
    }
    public void setFkBook(Book fkBook){
        this.fkBook = fkBook;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id,this.fkUser, this.fkBook);
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
        return  Objects.equals(this.id, other.id) && Objects.equals(this.fkUser, other.fkUser) && Objects.equals(this.fkBook, other.fkBook);
    }
}
