package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.dto.StreetDto;
import ru.vistar.kionmarket.service.StreetService;
import ru.vistar.kionmarket.service.impl.StreetServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses/streets")
public class StreetController {
    final StreetService streetService;

    public StreetController(StreetServiceImpl streetService) {
        this.streetService = streetService;
    }

    @PostMapping
    public ResponseEntity<StreetDto> create(@RequestBody StreetDto streetDto){
        return ResponseEntity.ok(streetService.create(streetDto));
    }
    @PutMapping
    public ResponseEntity<StreetDto> update(@RequestBody StreetDto streetDto){
        return ResponseEntity.ok(streetService.update(streetDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StreetDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(streetService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<StreetDto>> findAll(){
        return ResponseEntity.ok(streetService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        streetService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
