package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.dto.PurchaseRequestDto;
import ru.vistar.kionmarket.dto.PurchaseResponseDto;
import ru.vistar.kionmarket.service.PurchaseService;
import ru.vistar.kionmarket.service.impl.PurchaseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseServiceImpl purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDto> create(@RequestBody PurchaseRequestDto purchaseRequestDto){
        return ResponseEntity.ok(purchaseService.create(purchaseRequestDto));
    }

    @PutMapping("/{purchaseId}")
    public ResponseEntity<PurchaseResponseDto> update(@PathVariable Long purchaseId, @RequestBody PurchaseRequestDto purchaseRequestDto){
        return ResponseEntity.ok(purchaseService.update(purchaseId, purchaseRequestDto));
    }

    @GetMapping("/{purchaseId}")
    public ResponseEntity<PurchaseResponseDto> findById(@PathVariable Long purchaseId){
        return ResponseEntity.ok(purchaseService.findById(purchaseId));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponseDto>> findAll(@RequestParam Long purchaseStatusId){
        return ResponseEntity.ok(purchaseService.findAllByPurchaseStatusId(purchaseStatusId));
    }

    @DeleteMapping("/{purchaseId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long purchaseId){
        purchaseService.deleteById(purchaseId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestParam Long productId,
            @RequestParam Long purchaseStatusId){
        purchaseService.delete(productId, purchaseStatusId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{purchaseId}")
    public ResponseEntity<PurchaseResponseDto> patch(@PathVariable Long purchaseId, @RequestBody PurchaseRequestDto purchaseRequestDto){
        return ResponseEntity.ok(purchaseService.patch(purchaseId, purchaseRequestDto));
    }
}
