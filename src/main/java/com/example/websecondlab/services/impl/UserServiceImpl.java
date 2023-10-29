package com.example.websecondlab.services.impl;

import com.example.websecondlab.services.dtos.UserDTO;
import com.example.websecondlab.models.User;
import com.example.websecondlab.repositories.UserRepository;
import com.example.websecondlab.services.UserService;
import com.example.websecondlab.consts.enums.RoleEnum;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    @Transactional
    public void deleteUserByUserName(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public List<UserDTO> getUsersByRole(String role) {
        List<UserDTO> usersByRole = null;
        if (role.equalsIgnoreCase("user")) {
            usersByRole = userRepository.findAllByRole_RoleEquals(RoleEnum.USER)
                    .stream()
                    .map(user -> modelMapper.map(user, UserDTO.class))
                    .collect(Collectors.toList());
        } else if (role.equalsIgnoreCase("admin")) {
            usersByRole = userRepository.findAllByRole_RoleEquals(RoleEnum.ADMIN)
                    .stream()
                    .map(user -> modelMapper.map(user, UserDTO.class))
                    .collect(Collectors.toList());
        }
        return usersByRole;
    }
}