package com.oliveiradev.course.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.oliveiradev.course.workshopmongo.domain.Post;
import com.oliveiradev.course.workshopmongo.domain.User;
import com.oliveiradev.course.workshopmongo.dto.AuthorDTO;
import com.oliveiradev.course.workshopmongo.dto.CommenDTO;
import com.oliveiradev.course.workshopmongo.repository.PostRepository;
import com.oliveiradev.course.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        userRepository.deleteAll();
        postRepository.deleteAll();

        User tanjiro = new User(null, "Tanjiro Kamado", "tkamado@gmail.com");
        User yuji = new User(null, "Yuji Itadori", "yitadori@gmail.com");
        User zenitsu = new User(null, "Zenitsu Agatsuma", "zagatsuma@gmail.com");

        Post post1 = new Post(null, sdf.parse("01/01/2024"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(zenitsu));
        Post post2 = new Post(null, sdf.parse("05/01/2024"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(zenitsu));

        CommenDTO c1 = new CommenDTO("Boa viagem!", sdf.parse("06/01/2024"), new AuthorDTO(tanjiro));
        CommenDTO c2 = new CommenDTO("Aproveite", sdf.parse("06/01/2024"), new AuthorDTO(tanjiro));
        CommenDTO c3 = new CommenDTO("Venha para o Okinawa", sdf.parse("06/01/2024"), new AuthorDTO(yuji));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));
        
        userRepository.saveAll(Arrays.asList(tanjiro, yuji, zenitsu));
        postRepository.saveAll(Arrays.asList(post1, post2));

        zenitsu.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(zenitsu);


    }
}
