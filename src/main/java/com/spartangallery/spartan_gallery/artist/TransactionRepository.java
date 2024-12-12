package com.spartangallery.spartan_gallery.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    /**
     * Find transactions by user ID.
     * @param userId The ID of the user.
     * @return A list of transactions associated with the user.
     */
    List<Transaction> findByUserId(int userId);

    /**
     * Find transactions by art piece ID.
     * @param artPieceId The ID of the art piece.
     * @return A list of transactions associated with the art piece.
     */
    List<Transaction> findByArtPieceId(int artPieceId);
}
