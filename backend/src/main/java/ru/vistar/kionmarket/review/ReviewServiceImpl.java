package ru.vistar.kionmarket.review;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.user.User;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.product.ProductRepository;
import ru.vistar.kionmarket.user.UserRepository;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Review create(ReviewDto reviewDto) {
        Integer rating = reviewDto.getRating();
        String content = reviewDto.getContent();
        User user = userRepository.findById(reviewDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with id %1$s not found", reviewDto.getUserId())));
        Product product = productRepository.findById(reviewDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", reviewDto.getProductId())));
        Review review = new Review(rating, content, user, product);
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long reviewId, ReviewDto reviewDto) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Review with id %1$s not found", reviewId)));
        User user = userRepository.findById(reviewDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with id %1$s not found", reviewDto.getUserId())));
        Product product = productRepository.findById(reviewDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", reviewDto.getProductId())));
        review.setRating(reviewDto.getRating());
        review.setContent(reviewDto.getContent());
        review.setUser(user);
        review.setProduct(product);
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Review with id %1$s not found", reviewId)));
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
