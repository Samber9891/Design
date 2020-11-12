package com.tts.designlab.repository;

import java.util.List;

import com.tts.designlab.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<User, Long> {
    
    
    List<User> findByState(String state); 
}
