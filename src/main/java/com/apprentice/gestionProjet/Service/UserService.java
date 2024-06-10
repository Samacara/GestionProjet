//package com.apprentice.gestionProjet.Service;
//
//import com.apprentice.gestionProjet.Entity.Users;
//import com.apprentice.gestionProjet.Repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class UserService implements UserDetailsService {
//    private UsersRepository usersRepository;
//    @Autowired
//    public UserService(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = usersRepository.findByUsername(username).get();
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//    }
//}
