package ru.vistar.kionmarket.addresstype;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.address.Address;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/address-types")
public class AddressTypeController {

    private final AddressTypeService addressTypeService;
    
    public AddressTypeController(AddressTypeServiceImpl addressTypeService) {
        this.addressTypeService = addressTypeService;
    }

    @PostMapping
    public ResponseEntity<AddressType> create(@RequestBody AddressTypeDto addressTypeDto){
        return ResponseEntity.ok(addressTypeService.create(addressTypeDto));
    }

    @PutMapping("/{addressTypeId}")
    public ResponseEntity<AddressType> update(@PathVariable Long addressTypeId, @RequestBody AddressTypeDto addressTypeDto){
        return ResponseEntity.ok(addressTypeService.update(addressTypeId, addressTypeDto));
    }

    @GetMapping("/{addressTypeId}")
    public ResponseEntity<AddressType> findById(@PathVariable Long addressTypeId){
        return ResponseEntity.ok(addressTypeService.findById(addressTypeId));
    }

    @GetMapping
    public ResponseEntity<List<AddressType>> findAll(){
        return ResponseEntity.ok(addressTypeService.findAll());
    }

    @GetMapping("/{addressTypeId}/addresses")
    public ResponseEntity<Set<Address>> getAddresses(@PathVariable Long addressTypeId){
        return ResponseEntity.ok(addressTypeService.getAddresses(addressTypeId));
    }

    @DeleteMapping("/{addressTypeId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long addressTypeId){
        addressTypeService.deleteById(addressTypeId);
        return ResponseEntity.ok().build();
    }
}
