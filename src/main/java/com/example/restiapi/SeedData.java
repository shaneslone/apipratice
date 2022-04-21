package com.example.restiapi;

import com.example.restiapi.models.Name;
import com.example.restiapi.models.User;
import com.example.restiapi.models.VideoGame;
import com.example.restiapi.repository.UserRepository;
import com.example.restiapi.repository.VideoGameRepository;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoGameRepository videoGameRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(new Name("Shane", "Emory", "Slone"), "slone.shane@gmail.com", LocalDate.of(1986, Month.AUGUST, 8));
        User user2 = new User(new Name("Afton", "Slone"), "afton.slone@gmail.com", LocalDate.of(1984, Month.AUGUST, 23));

        VideoGame videoGame1 = new VideoGame("Halo", "Shooter", LocalDate.of(2001, Month.NOVEMBER, 15));
        videoGameRepository.save(videoGame1);

        user1.getVideoGames().add(videoGame1);
        user2.getVideoGames().add(videoGame1);

        userRepository.saveAll(List.of(user1, user2));
    }
}
