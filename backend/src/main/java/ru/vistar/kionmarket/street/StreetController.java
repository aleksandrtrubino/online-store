package ru.vistar.kionmarket.street;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/streets")
public class StreetController {

    private final StreetService streetService;

    public StreetController(StreetServiceImpl streetService) {
        this.streetService = streetService;
    }

    @PostMapping
    public ResponseEntity<Street> create(@RequestBody StreetDto streetDto){
        return ResponseEntity.ok(streetService.create(streetDto));
    }

    @PutMapping("/{streetId}")
    public ResponseEntity<Street> update(@PathVariable Long streetId, @RequestBody StreetDto streetDto){
        return ResponseEntity.ok(streetService.update(streetId, streetDto));
    }

    @GetMapping("/{streetId}")
    public ResponseEntity<Street> findById(@PathVariable Long streetId){
        return ResponseEntity.ok(streetService.findById(streetId));
    }

    @GetMapping
    public ResponseEntity<List<Street>> findAll(){
        return ResponseEntity.ok(streetService.findAll());
    }

    @DeleteMapping("/{streetId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long streetId){
        streetService.deleteById(streetId);
        return ResponseEntity.ok().build();
    }
}
