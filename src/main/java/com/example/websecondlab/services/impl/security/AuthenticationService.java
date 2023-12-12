package com.example.websecondlab.services.impl.security;

import com.example.websecondlab.models.User;
import com.example.websecondlab.repositories.RoleRepository;
import com.example.websecondlab.repositories.UserRepository;
import com.example.websecondlab.services.RoleService;
import com.example.websecondlab.services.UserService;
import com.example.websecondlab.web.view.user_input.RegisterViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.websecondlab.consts.enums.RoleEnum.USER;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public AuthenticationService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void registerUser(RegisterViewModel newUser) {

        Optional<User> userByUsername = this.userRepository.findUserByUsername(newUser.getUsername());
        if (userByUsername.isPresent()) {
            throw new RuntimeException("Username is already used");
        }

        User newUserModel = this.modelMapper.map(newUser, User.class);
        newUserModel.setRole(this.roleRepository.findRoleByRole(USER));
        newUserModel.setActive(true);
        newUserModel.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
        this.userRepository.saveAndFlush(newUserModel);
    }
}