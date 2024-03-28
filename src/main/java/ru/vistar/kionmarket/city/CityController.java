package ru.vistar.kionmarket.city;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody CityDto cityDto){
        return ResponseEntity.ok(cityService.create(cityDto));
    }

    @PutMapping("{cityId}")
    public ResponseEntity<City> update(@PathVariable Long cityId, @RequestBody CityDto cityDto){
        return ResponseEntity.ok(cityService.update(cityId, cityDto));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> findById(@PathVariable Long cityId){
        return ResponseEntity.ok(cityService.findById(cityId));
    }

    @GetMapping
    public ResponseEntity<List<City>> findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long cityId){
        cityService.deleteById(cityId);
        return ResponseEntity.ok().build();
    }
}
