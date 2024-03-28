package ru.vistar.kionmarket.purchasestatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.purchase.Purchase;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/purchase-statuses")
public class PurchaseStatusController {

    private final PurchaseStatusService purchaseStatusService;

    public PurchaseStatusController(PurchaseStatusServiceImpl purchaseStatusService) {
        this.purchaseStatusService = purchaseStatusService;
    }

    @PostMapping
    public ResponseEntity<PurchaseStatus> create(@RequestBody PurchaseStatusDto purchaseStatusDto){
        return ResponseEntity.ok(purchaseStatusService.create(purchaseStatusDto));
    }

    @PutMapping("/{purchaseStatusId}")
    public ResponseEntity<PurchaseStatus> update(@PathVariable Long purchaseStatusId, @RequestBody PurchaseStatusDto purchaseStatusDto){
        return ResponseEntity.ok(purchaseStatusService.update(purchaseStatusId,purchaseStatusDto));
    }

    @GetMapping("/{purchaseStatusId}")
    public ResponseEntity<PurchaseStatus> findById(@PathVariable Long purchaseStatusId){
        return ResponseEntity.ok(purchaseStatusService.findById(purchaseStatusId));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseStatus>> findAll(){
        return ResponseEntity.ok(purchaseStatusService.findAll());
    }

    @DeleteMapping("/{purchaseStatusId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long purchaseStatusId){
        purchaseStatusService.deleteById(purchaseStatusId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{purchaseStatusId}/purchases")
    public ResponseEntity<Set<Purchase>> getPurchases(@PathVariable Long purchaseStatusId){
        return ResponseEntity.ok(purchaseStatusService.getPurchases(purchaseStatusId));
    }
}
