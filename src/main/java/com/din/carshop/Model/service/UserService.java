package com.din.carshop.Model.service;

import com.din.carshop.Model.dto.UserDTO;
import com.din.carshop.Model.entyties.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDTO> getAll();
    boolean save(UserDTO userDTO);
    void save(User user);
    boolean activateUser(String activateCode);

    User findByName(String name);

    void updateProfile(UserDTO dto);
}
