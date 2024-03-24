package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<HouseDto> create(@RequestBody HouseDto houseDto){
        return ResponseEntity.ok(houseService.create(houseDto));
    }
    @PutMapping
    public ResponseEntity<HouseDto> update(@RequestBody HouseDto houseDto){
        return ResponseEntity.ok((houseService.update(houseDto)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HouseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(houseService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<HouseDto>> findAll(){
        return ResponseEntity.ok(houseService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        houseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
