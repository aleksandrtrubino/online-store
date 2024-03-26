package ru.vistar.kionmarket.addresstype;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.address.Address;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/addressTypes")
public class AddressTypeController {
    private final AddressTypeService addressTypeService;
    public AddressTypeController(AddressTypeServiceImpl addressTypeService) {
        this.addressTypeService = addressTypeService;
    }

    @PostMapping
    public ResponseEntity<AddressType> create(@RequestBody AddressTypeDto addressTypeDto){
        return ResponseEntity.ok(addressTypeService.create(addressTypeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressType> update(@PathVariable Long id, @RequestBody AddressTypeDto addressTypeDto){
        return ResponseEntity.ok(addressTypeService.update(id, addressTypeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressType> findById(@PathVariable Long id){
        return ResponseEntity.ok(addressTypeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressType>> findAll(){
        return ResponseEntity.ok(addressTypeService.findAll());
    }

    @GetMapping("/{id}/addresses")
    public ResponseEntity<Set<Address>> getAddresses(@PathVariable Long id){
        return ResponseEntity.ok(addressTypeService.getAddresses(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        addressTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
