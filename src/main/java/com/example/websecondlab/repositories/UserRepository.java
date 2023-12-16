package com.example.websecondlab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websecondlab.consts.enums.RoleEnum;
import com.example.websecondlab.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserByUsername(String username);
    List<User> findAllByRole_RoleEquals(RoleEnum role);


    Optional<User> findUserByUsername(String username);
    User findByUsername(String username);
}