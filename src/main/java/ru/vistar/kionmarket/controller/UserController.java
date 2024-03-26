package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.UserDto;
import ru.vistar.kionmarket.service.UserService;
import ru.vistar.kionmarket.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.create(userDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable Long userId, @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.update(userId, userDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/authorities")
    public ResponseEntity<Set<Authority>> getAuthorities(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getAuthorities(userId));
    }

    @GetMapping("/{userId}/reviews")
    public ResponseEntity<Set<Review>> getReviews(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getReviews(userId));
    }
    @GetMapping("/{userId}/purchases")
    public ResponseEntity<Set<Purchase>> getPurchases(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getPurchases(userId));
    }

    @GetMapping("/{userId}/favorites")
    public ResponseEntity<Set<Product>> getFavorites(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getFavorites(userId));
    }

    @PostMapping("/{userId}/favorites/{productId}")
    public ResponseEntity<Void> addFavorite(@PathVariable Long userId, @PathVariable Long productId){
        userService.addFavorite(userId,productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/favorites/{productId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long userId, @PathVariable Long productId){
        userService.removeFavorite(userId,productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/addresses")
    public ResponseEntity<Address> getAddress(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getAddress(userId));
    }

    @PostMapping("/{userId}/addresses/{addressId}")
    public ResponseEntity<Void> addAddress(@PathVariable Long userId, @PathVariable Long addressId){
        userService.addAddress(userId,addressId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/addresses")
    public ResponseEntity<Void> removeAddress(@PathVariable Long userId){
        userService.removeAddress(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/shops")
    public ResponseEntity<Shop> getShop(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getShop(userId));
    }

    @PostMapping("/{userId}/shops/{shopId}")
    public ResponseEntity<Void> addShop(@PathVariable Long userId, @PathVariable Long shopId){
        userService.addShop(userId,shopId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/shops")
    public ResponseEntity<Void> removeShop(@PathVariable Long userId){
        userService.removeShop(userId);
        return ResponseEntity.ok().build();
    }
}
