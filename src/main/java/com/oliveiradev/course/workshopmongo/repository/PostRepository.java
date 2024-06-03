package com.oliveiradev.course.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oliveiradev.course.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
