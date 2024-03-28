package ru.vistar.kionmarket.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.address.Address;
import ru.vistar.kionmarket.authority.Authority;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.shop.Shop;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.create(userDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.update(userId, userDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id){
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
