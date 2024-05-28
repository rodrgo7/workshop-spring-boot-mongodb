package com.oliveiradev.course.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiradev.course.workshopmongo.domain.User;
import com.oliveiradev.course.workshopmongo.repository.UserRepository;
import com.oliveiradev.course.workshopmongo.services.exception.ObjectNoFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNoFoundException("Objeto não encontrado"));
    }
}
