package com.example.citypersonrole.service;

import com.example.citypersonrole.dao.RoleRepository;
import com.example.citypersonrole.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void save(Role role) {
        this.roleRepository.save(role);
    }

    public void delete(Long id) {
        this.roleRepository.deleteById(id);
    }

    public List<Role> roleList(String name) {
        return this.roleRepository.findAllByRole(name);
    }
}
