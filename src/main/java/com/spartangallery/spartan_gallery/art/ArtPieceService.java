package com.spartangallery.spartan_gallery.art;

import com.spartangallery.spartan_gallery.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtPieceService {
    @Autowired
    private ArtPieceRepository artPieceRepository;

    public List<ArtPiece> getAllArtPieces() {
        return artPieceRepository.findAll();
    }

    public ArtPiece getArtPieceById(Long id) {
        return artPieceRepository.findById(id).orElseThrow(() -> new RuntimeException("Art piece not found"));
    }

    public ArtPiece saveArtPiece(ArtPiece artPiece) {
        return artPieceRepository.save(artPiece);
    }

    public void deleteArtPieceById(Long id) {
        artPieceRepository.deleteById(id);
    }

    public ArtPiece purchaseArtPiece(Long artPieceId, User buyer){
        ArtPiece artPiece = artPieceRepository.findById(artPieceId).orElseThrow(() -> new RuntimeException("Art piece not found"));
        artPiece.setBuyer(buyer);
        return artPieceRepository.save(artPiece);
    }

    public List<ArtPiece> searchArtPieces(String keyword) {
        return null;
    }
}
