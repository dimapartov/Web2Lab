package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.UserDTO;
import com.example.websecondlab.web.view.user_input.RegisterViewModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> getUsersByRole(String role);
//----------------------------------------------------------------------------------------------------------------------
//    Business

//    void registerUser(String username, String password);
    void registerUser(RegisterViewModel newUser);
    void deleteUserByUserName(String username);

}