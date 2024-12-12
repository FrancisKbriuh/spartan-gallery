package com.spartangallery.spartan_gallery.art;

import com.spartangallery.spartan_gallery.artist.TransactionRepository;
import com.spartangallery.spartan_gallery.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtPieceService {
    @Autowired
    private ArtPieceRepository artPieceRepository;

    @Autowired
    private TransactionRepository transactionRepository;

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

    public boolean purchaseArtPiece(int id, int userId) {
        Optional<ArtPiece> artPieceOptional = artPieceRepository.findById(id);

        if (artPieceOptional.isPresent()) {
            ArtPiece artPiece = artPieceOptional.get();

            // Check if the art piece is already sold
            if (artPiece.isSold()) {
                return false;
            }

            // Create a new transaction
            Transaction transaction = new Transaction();
            transaction.setUserId(userId);
            transaction.setArtPieceId(id);
            transaction.setAmount(artPiece.getPrice());

            transactionRepository.save(transaction);

            // Mark the art piece as sold
            artPiece.setSold(true);
            artPieceRepository.save(artPiece);

            return true;
        }

        return false;
    }

    public List<ArtPiece> searchArtPieces(String keyword) {
        return artPieceRepository.findByTitleContainingIgnoreCaseOrArtistNameContainingIgnoreCase(keyword, keyword);
    }
}
