package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.dto.UserBuyerDto;
import ru.vistar.kionmarket.dto.UserDto;
import ru.vistar.kionmarket.service.UserBuyerService;
import ru.vistar.kionmarket.service.impl.UserBuyerServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users/buyers")
public class UserBuyerController {

    final UserBuyerService userBuyerService;

    public UserBuyerController(UserBuyerServiceImpl userBuyerService) {
        this.userBuyerService = userBuyerService;
    }

    @PostMapping("/addresses/{addressId}")
    public ResponseEntity<UserBuyerDto> create(@RequestBody UserDto userDto, @PathVariable Long addressId){
        return ResponseEntity.ok(userBuyerService.create(userDto, addressId));
    }

    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<UserBuyerDto> update(@RequestBody UserDto userDto, @PathVariable Long addressId) {
        return ResponseEntity.ok(userBuyerService.update(userDto, addressId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserBuyerDto> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userBuyerService.findById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserBuyerDto>> findAll(){
        return ResponseEntity.ok(userBuyerService.findAll());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long userId){
        userBuyerService.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
