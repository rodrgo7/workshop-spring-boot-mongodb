package com.oliveiradev.course.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oliveiradev.course.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

    // List<Post> findByTitleContaining(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}