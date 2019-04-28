package com.example.simplediary_springbootex;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Model class
//Lombok을 사용하여 코드 간결화(클래스/필드 단위)

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String user;
    private String title;
    private String content;


    public void setUser(String user) {
        this.user = user;
    }
}
