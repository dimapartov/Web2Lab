package com.example.websecondlab.services.impl;

import com.example.websecondlab.services.domain_services.RoleServiceDomain;
import com.example.websecondlab.services.dtos.RoleDTO;
import com.example.websecondlab.services.dtos.UserDTO;
import com.example.websecondlab.models.User;
import com.example.websecondlab.repositories.UserRepository;
import com.example.websecondlab.services.UserService;
import com.example.websecondlab.consts.enums.RoleEnum;
import com.example.websecondlab.web.view.user_input.RegisterViewModel;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.websecondlab.consts.enums.RoleEnum.USER;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleServiceDomain roleServiceDomain;


    @Override
    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.saveAndFlush(user);
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
            usersByRole = userRepository.findAllByRole_RoleEquals(USER)
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
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void registerUser(RegisterViewModel newUser) {
        UserDTO newUserDTO = modelMapper.map(newUser, UserDTO.class); // Нужно ли из вью модели делать ДТО и далее работать с ней?
        RoleDTO userRole = modelMapper.map(roleServiceDomain.getUserRole(), RoleDTO.class);
        newUserDTO.setRole(userRole);
        this.addUser(newUserDTO);
    }
}