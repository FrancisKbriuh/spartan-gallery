package com.spartangallery.spartan_gallery.art;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArtPieceRepository extends JpaRepository<ArtPiece, Long> {
    List<ArtPiece> findByTitleContaining(String keyword);
}
