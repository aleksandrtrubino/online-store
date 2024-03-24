package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.service.CityService;
import ru.vistar.kionmarket.service.impl.CityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses/cities")
public class CityController {
    final CityService cityService;

    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }
    @PostMapping
    public ResponseEntity<CityDto> create(@RequestBody CityDto cityDto){
        return ResponseEntity.ok(cityService.create(cityDto));
    }
    @PutMapping
    public ResponseEntity<CityDto> update(@RequestBody CityDto cityDto){
        return ResponseEntity.ok(cityService.update(cityDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<CityDto>> findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cityService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
