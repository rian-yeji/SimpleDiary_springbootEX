package com.example.simplediary_springbootex;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiaryListRepository extends CrudRepository<Diary, Long> {

    List<Diary> findByUser(String user);
    List<Diary> findAll();

}
