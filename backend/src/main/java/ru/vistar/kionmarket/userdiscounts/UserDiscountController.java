package ru.vistar.kionmarket.userdiscounts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user_discounts")
public class UserDiscountController {
    private final UserDiscountService userDiscountService;

    public UserDiscountController(UserDiscountServiceImpl userDiscountService) {
        this.userDiscountService = userDiscountService;
    }

    @PostMapping
    public ResponseEntity<UserDiscount> create(@RequestBody UserDiscountDto userDiscountDto){
        return ResponseEntity.ok(userDiscountService.create(userDiscountDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDiscount> update(@PathVariable Long id, @RequestBody UserDiscountDto userDiscountDto){
        return ResponseEntity.ok(userDiscountService.update(id, userDiscountDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDiscount> findById(@PathVariable Long id){
        return ResponseEntity.ok(userDiscountService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<UserDiscount>> findAll(){
        return ResponseEntity.ok(userDiscountService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userDiscountService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
