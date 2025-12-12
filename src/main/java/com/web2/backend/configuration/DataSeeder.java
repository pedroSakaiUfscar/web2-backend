package com.web2.backend.configuration;

import com.web2.backend.model.Album;
import com.web2.backend.model.Artist;
import com.web2.backend.repository.AlbumRepository;
import com.web2.backend.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public void run(String... args) throws Exception {
        seedAlbums();
        seedArtists();
    }

    private void seedAlbums() {
        if (albumRepository.count() == 0) {
            createAlbum("Folklore", "Folk Pop", "https://assets.b9.com.br/wp-content/uploads/2020/07/Taylor-Swift-Folklore-capa.jpg");
            createAlbum("Mayhem", "Dark Pop", "https://i.scdn.co/image/ab67616d0000b27388e3c02b1154c46429c367d3");
            createAlbum("In Rainbows", "Alternative Rock", "https://upload.wikimedia.org/wikipedia/pt/1/1f/In_Rainbows_capa.jpg");
            createAlbum("Gracinha", "Alternative R&B", "https://i.scdn.co/image/ab67616d0000b273c56667554988775657803372");
        }
    }

    private void seedArtists() {
        createArtist("Stefani Alisson", "Pop Indie", "São Paulo", "SP", "https://i.imgur.com/pic.png"); // Use a URL correta da imagem dela

        createArtist("Taylor Swift", "Pop Alternativo", "São Paulo", "SP", "https://i.imgur.com/fXymOor.jpeg");
        createArtist("Lady Gaga", "Eletrônica", "Rio de Janeiro", "RJ", "https://i.imgur.com/cbTBM6m.jpeg");
        createArtist("Lagum", "Pop", "Campinas", "SP", "https://i.scdn.co/image/ab6761610000e5eb6e9a16624a0604077699363d");
        createArtist("Bad Bunny", "Reggaeton", "Rio de Janeiro", "RJ", "https://media.gettyimages.com/id/2158605797/pt/foto/paris-france-bad-bunny-attends-the-dior-homme-menswear-spring-summer-2025-show-as-part-of.jpg?s=612x612&w=0&k=20&c=o2frjOVa0g2Zf6lUywkTVc4RqLJIgnFyLqArff63ISQ=");
    }

    // Helper methods
    private void createAlbum(String name, String genre, String url) {
        Album a = new Album();
        a.setName(name);
        a.setGenre(genre);
        a.setImageUrl(url);
        albumRepository.save(a);
    }

    private void createArtist(String name, String genre, String city, String state, String url) {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setGenre(genre);
        artist.setCity(city);
        artist.setState(state);
        artist.setImageUrl(url);
        artistRepository.save(artist);
    }
}