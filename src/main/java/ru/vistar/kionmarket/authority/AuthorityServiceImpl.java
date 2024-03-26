package ru.vistar.kionmarket.authority;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.user.User;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.user.UserRepository;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    final UserRepository userRepository;
    final AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority create(AuthorityDto authorityDto) {
        Authority authority = new Authority();
        authority.setName(authorityDto.getName());
        return authorityRepository.save(authority);
    }

    @Override
    public Authority update(Long authorityId, AuthorityDto authorityDto) {
        Authority authority = authorityRepository.findById(authorityId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Authority with id %1$s not found",authorityId)));
        authority.setName(authorityDto.getName());
        return authorityRepository.save(authority);
    }

    @Override
    public Authority findById(Long authorityId) {
        return authorityRepository.findById(authorityId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Authority with id %1$s not found", authorityId)));
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
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
        Authority authority = authorityRepository.findById(authorityId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Authority with id %1$s not found",authorityId)));
        userRepository.findById(userId)
                .ifPresent(user -> {
                    user.getAuthorities().remove(authority);
                    userRepository.save(user);
                });
    }
}
