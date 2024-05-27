package com.oliveiradev.course.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.oliveiradev.course.workshopmongo.domain.User;
import com.oliveiradev.course.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args0) throws Exception {

        userRepository.deleteAll();

        User tanjiro = new User(null, "Tanjiro Kamado", "tkamado@gmail.com");
        User yuji = new User(null, "Yuji Itadori", "yitadori@gmail.com");
        User zenitsu = new User(null, "Zenitsu Agatsuma", "zagatsuma@gmail.com");

        userRepository.saveAll(Arrays.asList(tanjiro, yuji, zenitsu));
    }
}
