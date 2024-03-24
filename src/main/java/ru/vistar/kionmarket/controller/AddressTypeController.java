package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.dto.AddressTypeDto;
import ru.vistar.kionmarket.service.AddressTypeService;
import ru.vistar.kionmarket.service.impl.AddressTypeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses/types")
public class AddressTypeController {
    final AddressTypeService addressTypeService;

    public AddressTypeController(AddressTypeServiceImpl addressTypeService) {
        this.addressTypeService = addressTypeService;
    }

    @PostMapping
    public ResponseEntity<AddressTypeDto> create(@RequestBody AddressTypeDto addressTypeDto){
        return ResponseEntity.ok(addressTypeService.create(addressTypeDto));
    }

    @PutMapping
    public ResponseEntity<AddressTypeDto> update(@RequestBody AddressTypeDto addressTypeDto){
        return ResponseEntity.ok(addressTypeService.update(addressTypeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressTypeDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(addressTypeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressTypeDto>> findAll(){
        return ResponseEntity.ok(addressTypeService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        addressTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
