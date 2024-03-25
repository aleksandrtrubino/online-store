package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.AuthorityDto;

import java.util.List;

public interface AuthorityService {

    public AuthorityDto create(AuthorityDto authorityDto);//authorities
    public AuthorityDto update(AuthorityDto authorityDto);//authorities
    public AuthorityDto findById(Long id);//authorities/{authorityId}
    public List<AuthorityDto> findAll();//authorities
    public void deleteById(Long id);//authorities/{authorityId}

    public void grantAuthorityToUser(Long authorityId, Long userId);//authorities/{authorityId}/users/{userId}
    public void revokeAuthorityFromUser(Long authorityId, Long userId);//authorities/{authorityId}/users/{userId}
}
