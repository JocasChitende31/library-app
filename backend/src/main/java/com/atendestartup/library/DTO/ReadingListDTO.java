package com.atendestartup.library.DTO;

import com.atendestartup.library.entities.Book;
import com.atendestartup.library.entities.ReadingList;
import com.atendestartup.library.entities.User;
import org.springframework.data.jpa.repository.Query;

public record ReadingListDTO(String id, User fkUser, Book fkBook) {

}
