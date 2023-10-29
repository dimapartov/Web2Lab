package com.example.websecondlab.repositories;

import com.example.websecondlab.models.User;
import com.example.websecondlab.consts.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserByUsername(String username);

    List<User> findAllByRole_RoleEquals(RoleEnum role);

    User findUserByUsername(String username);

}