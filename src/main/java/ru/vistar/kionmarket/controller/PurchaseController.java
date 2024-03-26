package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.dto.PurchaseDto;
import ru.vistar.kionmarket.service.PurchaseService;
import ru.vistar.kionmarket.service.impl.PurchaseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    final PurchaseService purchaseService;

    public PurchaseController(PurchaseServiceImpl purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> create(@RequestBody PurchaseDto purchaseDto){
        return ResponseEntity.ok(purchaseService.create(purchaseDto));
    }

    @PutMapping("/{purchaseId}")
    public ResponseEntity<Purchase> update(@PathVariable Long purchaseId, @RequestBody PurchaseDto purchaseDto){
        return ResponseEntity.ok(purchaseService.update(purchaseId,purchaseDto));
    }

    @GetMapping("/{purchaseId}")
    public ResponseEntity<Purchase> findById(@PathVariable Long purchaseId){
        return ResponseEntity.ok(purchaseService.findById(purchaseId));
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> findAll(){
        return ResponseEntity.ok(purchaseService.findAll());
    }

    @DeleteMapping("/{purchaseId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long purchaseId){
        purchaseService.deleteById(purchaseId);
        return ResponseEntity.ok().build();
    }
}