package com.spartangallery.spartan_gallery.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> RunTimeException("Artist not found"));
    }

    public Artist saveArtist(Artist artist){
        return artistRepository.save(artist);
    }

    public void deleteArtistById(Long id) {
        artistRepository.deleteById(id);
    }

    public Artist login(String username, String password){
        return artistRepository.findByUsername(username)
                .filter(artist -> artist.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }
}
