package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.dto.AuthorityDto;
import ru.vistar.kionmarket.service.AuthorityService;
import ru.vistar.kionmarket.service.impl.AuthorityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class AuthorityController {

    final AuthorityService authorityService;

    public AuthorityController(AuthorityServiceImpl authorityService){
        this.authorityService = authorityService;
    }

    @PostMapping("/authorities")
    public ResponseEntity<AuthorityDto> create(@RequestBody AuthorityDto authorityDto){
        return ResponseEntity.ok(authorityService.create(authorityDto));
    }

    @PutMapping("/authorities")
    public ResponseEntity<AuthorityDto> update(@RequestBody AuthorityDto authorityDto){
        return ResponseEntity.ok(authorityService.update(authorityDto));
    }

    @GetMapping("/authorities/{id}")
    public ResponseEntity<AuthorityDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(authorityService.findById(id));
    }

    @GetMapping("/authorities")
    public ResponseEntity<List<AuthorityDto>> findAll(){
        return ResponseEntity.ok(authorityService.findAll());
    }

    @DeleteMapping("/authorities/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        authorityService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/authorities/{authorityId}")
    public ResponseEntity<Void>  grantAuthorityToUser(@PathVariable Long authorityId, @PathVariable Long userId){
        authorityService.grantAuthorityToUser(authorityId,userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/authorities/{authorityId}")
    public ResponseEntity<Void>  revokeAuthorityFromUser(@PathVariable Long authorityId, @PathVariable Long userId){
        authorityService.revokeAuthorityFromUser(authorityId,userId);
        return ResponseEntity.ok().build();
    }
}
