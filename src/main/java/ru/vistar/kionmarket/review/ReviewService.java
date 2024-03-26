package ru.vistar.kionmarket.review;

import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.review.ReviewDto;

import java.util.List;

public interface ReviewService {
    public Review create(ReviewDto reviewDto);//reviews
    public Review update(Long reviewId, ReviewDto reviewDto);//reviews/{reviewId}
    public Review findById(Long reviewId);//reviews/{reviewId}
    public List<Review> findAll();//reviews
    public void deleteById(Long reviewId);//reviews/{reviewId}
}
