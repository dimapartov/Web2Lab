package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.UserDTO;
import com.example.websecondlab.web.view.UserRegistrationView;

import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);
    void deleteUserByUserName(String username);

    List<UserDTO> getUsersByRole(String role);
//----------------------------------------------------------------------------------------------------------------------
    void registerUser(UserRegistrationView newUser);

}