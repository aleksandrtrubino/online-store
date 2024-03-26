package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Review;
import ru.vistar.kionmarket.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    public Review create(ReviewDto reviewDto);//reviews
    public Review update(Long reviewId, ReviewDto reviewDto);//reviews/{reviewId}
    public Review findById(Long reviewId);//reviews/{reviewId}
    public List<Review> findAll();//reviews
    public void deleteById(Long reviewId);//reviews/{reviewId}
}
