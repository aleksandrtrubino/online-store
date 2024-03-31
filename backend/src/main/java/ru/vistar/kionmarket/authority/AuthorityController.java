package ru.vistar.kionmarket.authority;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authorities")
public class AuthorityController {

    private final AuthorityService authorityService;

    public AuthorityController(AuthorityServiceImpl authorityService){
        this.authorityService = authorityService;
    }

    @PostMapping
    public ResponseEntity<Authority> create(@RequestBody AuthorityDto authorityDto){
        return ResponseEntity.ok(authorityService.create(authorityDto));
    }

    @PutMapping("/{authorityId}")
    public ResponseEntity<Authority> update(@PathVariable Long authorityId, @RequestBody AuthorityDto authorityDto){
        return ResponseEntity.ok(authorityService.update(authorityId, authorityDto));
    }

    @GetMapping("/{authorityId}")
    public ResponseEntity<Authority> findById(@PathVariable Long authorityId){
        return ResponseEntity.ok(authorityService.findById(authorityId));
    }

    @GetMapping
    public ResponseEntity<List<Authority>> findAll(){
        return ResponseEntity.ok(authorityService.findAll());
    }

    @DeleteMapping("/{authorityId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long authorityId){
        authorityService.deleteById(authorityId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{authorityId}/users/{userId}")
    public ResponseEntity<Void>  grantAuthorityToUser(@PathVariable Long authorityId, @PathVariable Long userId){
        authorityService.grantAuthorityToUser(authorityId,userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{authorityId}/users/{userId}")
    public ResponseEntity<Void>  revokeAuthorityFromUser(@PathVariable Long authorityId, @PathVariable Long userId){
        authorityService.revokeAuthorityFromUser(authorityId,userId);
        return ResponseEntity.ok().build();
    }
}
