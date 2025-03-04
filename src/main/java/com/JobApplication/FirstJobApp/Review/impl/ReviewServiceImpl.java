package com.JobApplication.FirstJobApp.Review.impl;

import com.JobApplication.FirstJobApp.Review.Review;
import com.JobApplication.FirstJobApp.Review.ReviewRepository;
import com.JobApplication.FirstJobApp.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl  implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> review = reviewRepository.findByCompanyId(companyId);
        return review;
    }
}
