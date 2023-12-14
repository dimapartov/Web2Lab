package com.example.websecondlab.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websecondlab.models.Role;
import com.example.websecondlab.repositories.RoleRepository;
import com.example.websecondlab.services.RoleService;
import com.example.websecondlab.services.dtos.RoleDTO;

@Service
public class RoleServiceImpl implements RoleService {

    private final ModelMapper modelMapper;
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    /*@Override
    public void addRole(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        roleRepository.saveAndFlush(role);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .collect(Collectors.toList());
    }*/

//----------------------------------------------------------------------------------------------------------------------
//    Business

}