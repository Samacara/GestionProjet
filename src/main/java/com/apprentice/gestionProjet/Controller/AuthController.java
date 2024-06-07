package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.DTO.AuthenticationRequest;
import com.apprentice.gestionProjet.DTO.AuthenticationResponse;
import com.apprentice.gestionProjet.Security.AppUserDetailsService;
import com.apprentice.gestionProjet.Util.JwtUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("")
public class AuthController {


    private AuthenticationManager authenticationManager;

    private AppUserDetailsService appUserDetailsService;

    private HttpServletRequest request;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AppUserDetailsService appUserDetailsService, HttpServletRequest request) {
        this.authenticationManager = authenticationManager;
        this.appUserDetailsService = appUserDetailsService;
        this.request = request;
    }

    @PostMapping("/authentificate")
    public ResponseEntity<Object> userLogin(@RequestBody AuthenticationRequest jwtRequest) throws Exception{
        Authentication authResult = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                jwtRequest.getUsername(),
                jwtRequest.getPassword()
        ));

        UserDetails userDetails = appUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        User user = (User) authResult.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256(JwtUtil.SECRET);
        String jwtAccessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtUtil.EXPIRE_ACCESS_TOKEN))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("role", user.getAuthorities().stream().map(ga -> ga.getAuthority()).collect(Collectors.toList()))
                .sign(algorithm);

        String jwtRefreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtUtil.EXPIRE_REFRESH_TOKEN))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwtAccessToken,jwtRefreshToken);

        return  ok().body(authenticationResponse);
        //return ok().body(utilisateursService.login(utilisateursDto.getUsername(),utilisateursDto.getPassword()));
    }
}