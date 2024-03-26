package ru.vistar.kionmarket.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    final AddressService addressService;
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.create(addressDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.update(id, addressDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        addressService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
