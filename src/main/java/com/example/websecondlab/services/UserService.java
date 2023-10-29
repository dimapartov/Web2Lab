package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.UserDTO;
import com.example.websecondlab.web.view.user_input.RegisterModel;

import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);
    void deleteUserByUserName(String username);

    List<UserDTO> getUsersByRole(String role);
//----------------------------------------------------------------------------------------------------------------------
    void registerUser(RegisterModel newUser);

}