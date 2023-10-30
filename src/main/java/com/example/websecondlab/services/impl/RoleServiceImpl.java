package com.example.websecondlab.services.impl;

import com.example.websecondlab.consts.enums.RoleEnum;
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


    @Override
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
    }


//----------------------------------------------------------------------------------------------------------------------
    @Override
    public RoleDTO getUserRole() {
        return modelMapper.map(roleRepository.findRoleByRole(RoleEnum.USER), RoleDTO.class);
    }
}