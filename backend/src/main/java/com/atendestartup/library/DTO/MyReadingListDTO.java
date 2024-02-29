package com.atendestartup.library.DTO;

import com.atendestartup.library.projections.ReadingListProjection;

public class MyReadingListDTO {

    private String id;
    private  String user;
    private  String login;
    private  Long book;
    private  String title;
    private  String imgUrl;

    public MyReadingListDTO(ReadingListProjection projection){
        this.id = projection.getId();
        this.user = projection.getUser();
        this.login = projection.getLogin();
        this.book = projection.getBook();
        this.title = projection.getTitle();
        this.imgUrl = projection.getImgUrl();
    }

    public String getId(){
        return  this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getUser(){
        return  this.user;
    }
    public void setUser(String userId){
        this.user = userId;
    }
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public Long getBook(){
        return this.book;
    }
    public void setBook(Long bookId){
        this.book = bookId;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getImgUrl(){
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
}
