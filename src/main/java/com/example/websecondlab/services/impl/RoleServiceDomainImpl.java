package com.example.websecondlab.services.impl;

import com.example.websecondlab.consts.enums.RoleEnum;
import com.example.websecondlab.models.Role;
import com.example.websecondlab.repositories.RoleRepository;
import com.example.websecondlab.services.domain_services.RoleServiceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceDomainImpl implements RoleServiceDomain {

    private RoleRepository roleRepository;


    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role getUserRole() {
        return roleRepository.findRoleByRole(RoleEnum.USER);
    }
}