package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.AuthorityDto;

import java.util.List;

public interface AuthorityService {

    public AuthorityDto create(AuthorityDto authorityDto);
    public AuthorityDto update(AuthorityDto authorityDto);
    public AuthorityDto findById(Long id);
    public List<AuthorityDto> findAll();
    public void deleteById(Long id);

    public void grantAuthorityToUser(Long authorityId, Long userId);
    public void revokeAuthorityFromUser(Long authorityId, Long userId);
}
