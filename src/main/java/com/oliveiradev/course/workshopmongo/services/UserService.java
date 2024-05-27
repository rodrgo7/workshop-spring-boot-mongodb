package com.oliveiradev.course.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiradev.course.workshopmongo.domain.User;
import com.oliveiradev.course.workshopmongo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findall() {
        return repo.findAll();
    }
}
