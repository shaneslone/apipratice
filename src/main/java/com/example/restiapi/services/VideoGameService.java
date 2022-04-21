package com.example.restiapi.services;

import com.example.restiapi.models.VideoGame;
import com.example.restiapi.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    public VideoGame save(VideoGame videoGame){
        return videoGameRepository.save(videoGame);
    }
}
