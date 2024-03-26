package ru.vistar.kionmarket.authority;

import ru.vistar.kionmarket.authority.Authority;
import ru.vistar.kionmarket.authority.AuthorityDto;

import java.util.List;

public interface AuthorityService {

    public Authority create(AuthorityDto authorityDto);//authorities
    public Authority update(Long authorityId, AuthorityDto authorityDto);//authorities/{authorityId}
    public Authority findById(Long authorityId);//authorities/{authorityId}
    public List<Authority> findAll();//authorities
    public void deleteById(Long id);//authorities/{authorityId}

    public void grantAuthorityToUser(Long authorityId, Long userId);//authorities/{authorityId}/users/{userId}
    public void revokeAuthorityFromUser(Long authorityId, Long userId);//authorities/{authorityId}/users/{userId}
}
