package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO addUser(UserDTO userDTO);
    void deleteUserByUserName(String username);

    List<UserDTO> getUsersByRole(String role);
}