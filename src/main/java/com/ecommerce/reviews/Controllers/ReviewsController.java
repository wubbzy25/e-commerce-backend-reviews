package com.ecommerce.reviews.Controllers;

import com.ecommerce.reviews.Services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews/")
public class ReviewsController {

    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("getRandomReviews")
    public ResponseEntity<?> getRandomReviews() {
        return new ResponseEntity<>(reviewsService.getRandomReviews(), HttpStatus.OK);
    }


    @GetMapping("getReviewsByIdProduct")
    public ResponseEntity<?> getReviewsByProductId(@RequestParam Long productId,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "9") int Pagesize,
                                                   @RequestParam String sort){
        return new ResponseEntity<>(reviewsService.getReviewsByProductId(page,Pagesize,sort,productId), HttpStatus.OK);
    }
}
