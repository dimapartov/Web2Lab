package com.example.websecondlab.services;

import java.util.List;

import com.example.websecondlab.services.dtos.UserDTO;
import com.example.websecondlab.web.view.user_input.RegisterViewModel;

public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> getUsersByRole(String role);
//----------------------------------------------------------------------------------------------------------------------
//    Business

    void registerUser(RegisterViewModel newUser);
    void deleteUserByUserName(String username);

}