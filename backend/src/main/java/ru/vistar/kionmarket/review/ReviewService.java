package ru.vistar.kionmarket.review;

import java.util.List;

//reviews
public interface ReviewService {
    public Review create(ReviewDto reviewDto);// POST
    public Review update(Long reviewId, ReviewDto reviewDto);//{reviewId} PUT
    public Review findById(Long reviewId);//{reviewId} GET
    public List<Review> findAll();// GET
    public void deleteById(Long reviewId);//{reviewId} DELETE
}
