package com.spartangallery.spartan_gallery.art;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ArtPiece createArtPiece(@RequestBody ArtPiece artPiece) {
        return artPieceService.saveArtPiece(artPiece);
    }

    @PutMapping("/{id}")
    public ArtPiece updateArtPiece(@PathVariable Long id, @RequestParam String buyer) {
        return artPieceService.purchaseArtPiece(id, buyer);
    }
}

