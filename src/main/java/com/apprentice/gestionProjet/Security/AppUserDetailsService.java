package com.apprentice.gestionProjet.Security;
import com.apprentice.gestionProjet.DTO.UsersDto;
import com.apprentice.gestionProjet.Service.UsersServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AppUserDetailsService implements UserDetailsService {
    //    @Autowired
    private UsersServiceImpl utilisateursService;



    public AppUserDetailsService(UsersServiceImpl utilisateursService) {
        this.utilisateursService = utilisateursService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersDto utilisateurs = utilisateursService.getUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(utilisateurs.getRole()));
        return new User(utilisateurs.getUsername(), utilisateurs.getPassword(), authorities);
    }
}