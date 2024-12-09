package com.spartangallery.spartan_gallery.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ArtistRepository {
    Optional<Artist> findByUsername(String username);
}
