package ru.vistar.kionmarket.security;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.user.User;
import ru.vistar.kionmarket.user.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }


    public TokenDto openSession(HttpServletRequest request, HttpServletResponse response, AuthDto authDto){
        String email = authDto.getEmail();
        String password = authDto.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",email)));
        String username = user.getUsername();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, authorities));

        String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setMaxAge(jwtUtil.refreshTokenExpiration/1000);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);

        String accessToken = jwtUtil.generateAccessToken(userDetails);

        return new TokenDto(accessToken);
    }

    public TokenDto extendSession(HttpServletRequest request){
        String refreshToken = null;
        Cookie[] cookies = request.getCookies();
        if(cookies == null)
            throw new ResourceNotFoundException("Request does not include any cookies");
        for (Cookie c : cookies) {
            if (c.getName().equals("refreshToken"))
                refreshToken = c.getValue();
        }
        if(refreshToken == null )
            throw new ResourceNotFoundException("Cookie 'refreshToken' not found");

        String username = jwtUtil.getSubject(refreshToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String accessToken = jwtUtil.generateAccessToken(userDetails);

        return new TokenDto(accessToken);
    }

    public void closeSession(HttpServletResponse response){
        Cookie refreshTokenCookie = new Cookie("refreshToken", null);
        refreshTokenCookie.setMaxAge(0);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(true);
        response.addCookie(refreshTokenCookie);
    }
}
