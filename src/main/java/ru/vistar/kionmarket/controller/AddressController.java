package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.dto.AddressDto;
import ru.vistar.kionmarket.service.AddressService;
import ru.vistar.kionmarket.service.impl.AddressServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    final AddressService addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/types/{addressTypeId}/cities/{cityId}/streets/{streetId}/houses/{houseId}")
    public ResponseEntity<AddressDto> create(@PathVariable Long addressTypeId, @PathVariable Long cityId, @PathVariable Long streetId, @PathVariable Long houseId){
        return ResponseEntity.ok(addressService.create(addressTypeId,cityId,streetId,houseId));
    }

    @PutMapping("/{addressId}/types/{addressTypeId}/cities/{cityId}/streets/{streetId}/houses/{houseId}")
    public ResponseEntity<AddressDto> update(@PathVariable Long addressId, @PathVariable Long addressTypeId, @PathVariable Long cityId, @PathVariable Long streetId, @PathVariable Long houseId){
        return ResponseEntity.ok(addressService.update(addressId,addressTypeId,cityId,streetId,houseId));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDto> findById(@PathVariable Long addressId){
        return ResponseEntity.ok(addressService.findById(addressId));
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long addressId){
        addressService.deleteById(addressId);
        return ResponseEntity.ok().build();
    }
}
