package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Authority;
import ru.vistar.kionmarket.domain.User;
import ru.vistar.kionmarket.dto.AuthorityDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.AuthorityMapper;
import ru.vistar.kionmarket.repository.AuthorityRepository;
import ru.vistar.kionmarket.repository.UserRepository;
import ru.vistar.kionmarket.service.AuthorityService;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    final UserRepository userRepository;
    final AuthorityRepository authorityRepository;
    final AuthorityMapper authorityMapper;


    public AuthorityServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository, AuthorityMapper authorityMapper) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.authorityMapper = authorityMapper;
    }

    @Override
    public AuthorityDto create(AuthorityDto authorityDto) {
        Authority authority = authorityMapper.toEntity(authorityDto);
        return authorityMapper.toDto(authorityRepository.save(authority));
    }

    @Override
    public AuthorityDto update(AuthorityDto authorityDto) {
        Authority authority = authorityRepository.findById(authorityDto.getId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("Authority with id %1$s not found",authorityDto.getId())));
        authority.setName(authorityDto.getName());
        return authorityMapper.toDto(authorityRepository.save(authority));
    }

    @Override
    public AuthorityDto findById(Long id) {
        Authority authority = authorityRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Authority with id %1$s not found",id)));
        return authorityMapper.toDto(authority);
    }

    @Override
    public List<AuthorityDto> findAll() {
        return authorityMapper.toDto(authorityRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public void grantAuthorityToUser(Long authorityId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Authority authority = authorityRepository.findById(authorityId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Authority with id %1$s not found",authorityId)));
        user.getAuthorities().add(authority);
        userRepository.save(user);
    }

    @Override
    public void revokeAuthorityFromUser(Long authorityId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Authority authority = authorityRepository.findById(authorityId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Authority with id %1$s not found",authorityId)));
        user.getAuthorities().remove(authority);
        userRepository.save(user);
    }
}
