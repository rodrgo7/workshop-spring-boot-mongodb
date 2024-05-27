package com.oliveiradev.course.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiradev.course.workshopmongo.domain.User;


@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User Rodrigo = new User("1", "Rodrigo Oliveira", "rodrigo@gmail.com");
        User Fernanda = new User("2", "Fernanda Biazuzo", "fbiazuzo@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(Rodrigo, Fernanda));
        return ResponseEntity.ok().body(list);
    }
}
