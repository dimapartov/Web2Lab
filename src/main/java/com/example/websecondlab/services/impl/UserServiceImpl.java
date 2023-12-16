package com.example.websecondlab.services.impl;

import static com.example.websecondlab.consts.enums.RoleEnum.USER;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websecondlab.consts.enums.RoleEnum;
import com.example.websecondlab.models.User;
import com.example.websecondlab.repositories.RoleRepository;
import com.example.websecondlab.repositories.UserRepository;
import com.example.websecondlab.services.UserService;
import com.example.websecondlab.services.dtos.UserDTO;
import com.example.websecondlab.util.validation.Validation;
import com.example.websecondlab.web.view.user_input.RegisterViewModel;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final Validation validation;
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, Validation validation) {
        this.modelMapper = modelMapper;
        this.validation = validation;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    /*@Override
    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.saveAndFlush(user);
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
    }*/

//----------------------------------------------------------------------------------------------------------------------
//    Business

/*    @Override
    @Transactional
    public void deleteUserByUserName(String username) {
        userRepository.deleteUserByUsername(username);
    }*/

}