package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.House;
import ru.vistar.kionmarket.dto.HouseDto;
import ru.vistar.kionmarket.service.HouseService;
import ru.vistar.kionmarket.service.impl.HouseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses/houses")
public class HouseController {
    final HouseService houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }
    @PostMapping
    public ResponseEntity<House> create(@RequestBody HouseDto houseDto){
        return ResponseEntity.ok(houseService.create(houseDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<House> update(@PathVariable Long id, @RequestBody HouseDto houseDto){
        return ResponseEntity.ok((houseService.update(id, houseDto)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<House> findById(@PathVariable Long id){
        return ResponseEntity.ok(houseService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<House>> findAll(){
        return ResponseEntity.ok(houseService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        houseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
