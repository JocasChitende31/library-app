package com.atendestartup.library.DTO;

import com.atendestartup.library.entities.Book;
import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.entities.User;
import com.atendestartup.library.projections.ReadingListProjection;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.Query;
public class  ReadingListDTO {

    private String id;
    private String user;
    private Long book;

    public ReadingListDTO(){

    }
    public ReadingListDTO(ReadingList entity){
        BeanUtils.copyProperties(entity, this);
    }
    public  ReadingListDTO(ReadingListProjection projection){
        id = projection.getId();
        user = projection.getUser();
        book = projection.getBook();
    }
    public String getId(){
        return  this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getUser(){
        return this.user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public Long getBook(){
        return  this.book;
    }
    public void setBook(Long book){
        this.book = book;
    }
}
