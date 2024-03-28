package ru.vistar.kionmarket.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.create(addressDto));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Address> update(@PathVariable Long addressId, @RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.update(addressId, addressDto));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> findById(@PathVariable Long addressId){
        return ResponseEntity.ok(addressService.findById(addressId));
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long addressId){
        addressService.deleteById(addressId);
        return ResponseEntity.ok().build();
    }
}
