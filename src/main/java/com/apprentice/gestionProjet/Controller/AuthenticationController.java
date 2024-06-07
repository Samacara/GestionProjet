//package com.apprentice.gestionProjet.Controller;
//
//import com.apprentice.gestionProjet.DTO.AuthenticationRequest;
//import com.apprentice.gestionProjet.DTO.AuthenticationResponse;
//import com.apprentice.gestionProjet.Service.UserService;
//import com.apprentice.gestionProjet.Util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthenticationController {
//
//
//    private AuthenticationManager authenticationManager;
//    private final UserService userService;
//    private JwtUtil jwtUtil;
//    @Autowired
//    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.userService = userService;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping("/authentification")
//    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
//            );
//        } catch (Exception e) {
//            throw new Exception(" votre username ou password est Incorrect ", e);
//        }
//
//        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return new AuthenticationResponse(jwt);
//    }
//}
