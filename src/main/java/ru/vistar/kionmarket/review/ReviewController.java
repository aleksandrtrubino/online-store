package ru.vistar.kionmarket.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.review.ReviewDto;
import ru.vistar.kionmarket.review.ReviewService;
import ru.vistar.kionmarket.review.ReviewServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody ReviewDto reviewDto){
        return  ResponseEntity.ok(reviewService.create(reviewDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody ReviewDto reviewDto){
        return  ResponseEntity.ok(reviewService.update(id, reviewDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        return ResponseEntity.ok(reviewService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        reviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
