package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.Review;
import ru.vistar.kionmarket.dto.ReviewDto;
import ru.vistar.kionmarket.service.ReviewService;
import ru.vistar.kionmarket.service.impl.ReviewServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    final ReviewService reviewService;
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
