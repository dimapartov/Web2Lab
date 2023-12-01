package com.example.websecondlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websecondlab.consts.enums.RoleEnum;
import com.example.websecondlab.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRole(RoleEnum role);

}