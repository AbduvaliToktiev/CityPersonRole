package com.example.citypersonrole.dao;

import com.example.citypersonrole.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role>findAllByRole(String name);
}
