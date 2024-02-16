package com.atendestartup.library.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_reading_list")
public class ReadingList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id = UUID.randomUUID().toString();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;

}
