package com.web2.backend.controller;


import com.web2.backend.model.Album;
import com.web2.backend.model.Artist;
import com.web2.backend.repository.AlbumRepository;
import com.web2.backend.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@CrossOrigin(origins = "*")
public class HomeController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    // URL: http://localhost:8080/api/home/albums
    @GetMapping("/albums")
    public List<Album> getNewReleases() {
        return albumRepository.findAll();
    }

    // URL: http://localhost:8080/api/home/artists
    @GetMapping("/artists")
    public List<Artist> getSuggestedArtists() {
        return artistRepository.findAll();
    }
}