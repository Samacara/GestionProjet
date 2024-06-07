package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.UsersDto;
import com.apprentice.gestionProjet.Entity.Users;
import com.apprentice.gestionProjet.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersServiceImpl implements UsersService{
    private final PasswordEncoder passwordEncoder;
    private UsersRepository usersRepository;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> datas = usersRepository.findAll();
        List<UsersDto> list = new ArrayList<>();
        for (Users us : datas){
            list.add(UsersDto.fromEntity(us));
        }
        return list;
    }

    @Override
    public UsersDto saveUsers(UsersDto usersDto) {
        usersDto.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        Users us = usersRepository.save(UsersDto.toEntity(usersDto));
        return UsersDto.fromEntity(us);
    }

    @Override
    public UsersDto updateUsers(UsersDto usersDto, Integer idUsers) {
        Users foundUsers = usersRepository.findById(idUsers).get();
        if (foundUsers !=null){
            foundUsers.setId(usersDto.getId());
            foundUsers.setEmail(usersDto.getEmail());
            foundUsers.setUsername(usersDto.getUsername());
            foundUsers.setRole(usersDto.getRole());
            foundUsers.setPassword(passwordEncoder.encode(usersDto.getPassword()));
//            foundUsers.setPassword(usersDto.getPassword());

            Users us = usersRepository.save(foundUsers);
            return UsersDto.fromEntity(us);
        }
        return null;
    }

    @Override
    public UsersDto getOneUser(Integer idUsers) {
        Users us = usersRepository.findById(idUsers).get();
        return UsersDto.fromEntity(us);
    }

    @Override
    public UsersDto getUserByUsername(String Usename) {
        Users us = usersRepository.findByUsername(Usename).get();
        return UsersDto.fromEntity(us);
    }

    @Override
    public void deleteUsers(Integer idUsers) {
        usersRepository.deleteById(idUsers);

    }
}
