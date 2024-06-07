package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.UsersDto;

import java.util.List;

public interface UsersService  {

    public List<UsersDto> getAllUsers();

    public UsersDto saveUsers(UsersDto usersDto);

    public UsersDto updateUsers(UsersDto usersDto, Integer idUsers);

    public UsersDto getOneUser(Integer idUsers);

    public  UsersDto getUserByUsername(String Usename);

    public void deleteUsers(Integer idUsers);
}
