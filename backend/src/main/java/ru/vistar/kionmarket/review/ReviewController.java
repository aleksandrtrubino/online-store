package ru.vistar.kionmarket.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> update(@PathVariable Long reviewId, @RequestBody ReviewDto reviewDto){
        return  ResponseEntity.ok(reviewService.update(reviewId, reviewDto));
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> findById(@PathVariable Long reviewId){
        return ResponseEntity.ok(reviewService.findById(reviewId));
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        return ResponseEntity.ok(reviewService.findAll());
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long reviewId){
        reviewService.deleteById(reviewId);
        return ResponseEntity.ok().build();
    }
}
