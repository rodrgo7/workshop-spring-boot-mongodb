package com.oliveiradev.course.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiradev.course.workshopmongo.domain.Post;
import com.oliveiradev.course.workshopmongo.repository.PostRepository;
import com.oliveiradev.course.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional <Post> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        // return repo.findByTitleContaining(text);
        return repo.findByTitleContainingIgnoreCase(text);
    }    
}