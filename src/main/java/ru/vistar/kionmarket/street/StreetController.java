package ru.vistar.kionmarket.street;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses/streets")
public class StreetController {
    private final StreetService streetService;
    public StreetController(StreetServiceImpl streetService) {
        this.streetService = streetService;
    }

    @PostMapping
    public ResponseEntity<Street> create(@RequestBody StreetDto streetDto){
        return ResponseEntity.ok(streetService.create(streetDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Street> update(@PathVariable Long id, @RequestBody StreetDto streetDto){
        return ResponseEntity.ok(streetService.update(id, streetDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Street> findById(@PathVariable Long id){
        return ResponseEntity.ok(streetService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Street>> findAll(){
        return ResponseEntity.ok(streetService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        streetService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
