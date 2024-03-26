package ru.vistar.kionmarket.city;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.city.City;
import ru.vistar.kionmarket.city.CityDto;
import ru.vistar.kionmarket.city.CityService;
import ru.vistar.kionmarket.city.CityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses/cities")
public class CityController {
    final CityService cityService;
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody CityDto cityDto){
        return ResponseEntity.ok(cityService.create(cityDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody CityDto cityDto){
        return ResponseEntity.ok(cityService.update(id, cityDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<City>> findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        cityService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
