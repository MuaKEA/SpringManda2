package com.example.demo.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WaitinglistRepo extends CrudRepository<waitingList,Long> {

    Student findAllById(Long id);

    List<waitingList> waitingstudent(Long id);

}
