package com.spartangallery.spartan_gallery.user;

import com.spartangallery.spartan_gallery.art.ArtPiece;
import jakarta.persistence.*;

import java.awt.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<ArtPiece> purchasedArtPieces;

    public User(List<ArtPiece> purchasedArtPieces) {
        super();
        this.purchasedArtPieces = purchasedArtPieces;
    }

    public User(Long id, String username, String password, List<ArtPiece> purchasedArtPieces) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.purchasedArtPieces = purchasedArtPieces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ArtPiece> getPurchasedArtPieces() {
        return purchasedArtPieces;
    }

    public void setPurchasedArtPieces(List<ArtPiece> purchasedArtPieces) {
        this.purchasedArtPieces = purchasedArtPieces;
    }
}
