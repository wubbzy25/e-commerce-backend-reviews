package com.ecommerce.reviews.Repositories;

import com.ecommerce.reviews.Models.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    @Query( value = "SELECT r.*, u.name " +
            "FROM reviews r " + "JOIN users u ON r.id_user = u.id_user " +
            "ORDER BY RANDOM() " +
            "LIMIT 4",
            nativeQuery = true )
    List<Review> getReviewRandom();

    @Query( value = "SELECT r.*, u.name " +
            "FROM reviews r " + "JOIN users u ON r.id_user = u.id_user " +
            "WHERE r.id_product = :productId " +
            "ORDER BY r.score DESC",
            nativeQuery = true )
    Page<Review> getReviewsByProductId(Pageable pageable, Long productId);


}
