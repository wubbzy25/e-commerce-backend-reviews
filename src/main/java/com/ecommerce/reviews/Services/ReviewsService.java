package com.ecommerce.reviews.Services;

import com.ecommerce.reviews.Models.Review;
import com.ecommerce.reviews.Repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;
    ;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public List<Review> getRandomReviews() {
        return reviewsRepository.getReviewRandom();
    }



    public Page<Review> getReviewsByProductId(int page, int Pagesize, String sort, Long product_id) {
        String[] sortParams = sort.split(",");
        Sort sortOrder = Sort.by(sortParams[0]).ascending();
        if (sortParams[1].equalsIgnoreCase("desc")) {
            sortOrder = Sort.by(sortParams[0]).descending();
        }
        Pageable pageable = PageRequest.of(page,Pagesize, sortOrder);

       return reviewsRepository.getReviewsByProductId(pageable,product_id);
    }
}
