package com.example.websecondlab.services.impl;

import com.example.websecondlab.services.dtos.RoleDTO;
import com.example.websecondlab.models.Role;
import com.example.websecondlab.repositories.RoleRepository;
import com.example.websecondlab.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public RoleDTO addRole(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        roleRepository.save(role);
        return modelMapper.map(role, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .collect(Collectors.toList());
    }
}