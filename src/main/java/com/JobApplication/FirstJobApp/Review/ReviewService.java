package com.JobApplication.FirstJobApp.Review;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyID);
}
