package com.example.citypersonrole.service;

import com.example.citypersonrole.dao.UsersRepository;
import com.example.citypersonrole.entity.Role;
import com.example.citypersonrole.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    public void save(Users users) {
        this.usersRepository.save(users);
    }

    public void delete(Long id) {
        this.usersRepository.deleteById(id);
    }

    public List<Users> usersList() {
        return this.usersRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = usersRepository.findFirstByEmail(email);

        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Role> roleList = users.getRoles();

        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(users.getEmail(), users.getPassword(), authorities);
    }
}
