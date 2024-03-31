package ru.vistar.kionmarket.house;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/houses")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public ResponseEntity<House> create(@RequestBody HouseDto houseDto){
        return ResponseEntity.ok(houseService.create(houseDto));
    }

    @PutMapping("/{houseId}")
    public ResponseEntity<House> update(@PathVariable Long houseId, @RequestBody HouseDto houseDto){
        return ResponseEntity.ok((houseService.update(houseId, houseDto)));
    }

    @GetMapping("/{houseId}")
    public ResponseEntity<House> findById(@PathVariable Long houseId){
        return ResponseEntity.ok(houseService.findById(houseId));
    }

    @GetMapping
    public ResponseEntity<List<House>> findAll(){
        return ResponseEntity.ok(houseService.findAll());
    }

    @DeleteMapping("/{houseId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long houseId){
        houseService.deleteById(houseId);
        return ResponseEntity.ok().build();
    }
}
