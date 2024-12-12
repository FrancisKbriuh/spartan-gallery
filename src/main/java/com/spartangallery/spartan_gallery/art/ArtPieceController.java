package com.spartangallery.spartan_gallery.art;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artpieces")
public class ArtPieceController {

    @Autowired
    private ArtPieceService artPieceService;

    @GetMapping("/")
    public String home() {
        return "Welcome to Spartan Gallery";
    }

    @GetMapping("/search")
    public List<ArtPiece> searchArtPieces(@RequestParam String keyword) {
        return artPieceService.searchArtPieces(keyword);
    }

    @GetMapping
    public List<ArtPiece> getAllArtPieces() {
        return artPieceService.getAllArtPieces();
    }

    @PostMapping("/purchase/{id}")
    public ResponseEntity<String> purchaseArtPiece(@PathVariable int id, @RequestParam int userId) {
        boolean success = artPieceService.purchaseArtPiece(id, userId);
        if (success) {
            return ResponseEntity.ok("Art piece purchased successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Purchase failed. Art piece may not be available.");
        }
    }

    @PostMapping
    public ArtPiece createArtPiece(@RequestBody ArtPiece artPiece) {
        return artPieceService.saveArtPiece(artPiece);
    }

    @PutMapping("/{id}")
    public ArtPiece updateArtPiece(@PathVariable Long id, @RequestParam String buyer) {
        return artPieceService.purchaseArtPiece(id, buyer);
    }
}

