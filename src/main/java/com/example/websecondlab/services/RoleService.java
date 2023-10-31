package com.example.websecondlab.services;

import com.example.websecondlab.services.dtos.RoleDTO;

import java.util.List;

public interface RoleService {

    void addRole(RoleDTO roleDTO);

    List<RoleDTO> getAllRoles();
//----------------------------------------------------------------------------------------------------------------------
//    Business
}