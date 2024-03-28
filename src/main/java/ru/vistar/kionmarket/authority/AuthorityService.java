package ru.vistar.kionmarket.authority;

import java.util.List;

//authorities
public interface AuthorityService {

    public Authority create(AuthorityDto authorityDto);// POST
    public Authority update(Long authorityId, AuthorityDto authorityDto);//{authorityId} PUT
    public Authority findById(Long authorityId);//{authorityId} GET
    public List<Authority> findAll();// GET
    public void deleteById(Long id);//{authorityId} DELETE

    public void grantAuthorityToUser(Long authorityId, Long userId);//{authorityId}/users/{userId} POST
    public void revokeAuthorityFromUser(Long authorityId, Long userId);//{authorityId}/users/{userId} DELETE

    //public Set<User> getUsers(Long authorityId);//{authorityId}/users
}
