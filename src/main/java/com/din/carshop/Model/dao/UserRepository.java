package com.din.carshop.Model.dao;

import com.din.carshop.Model.entyties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByName(String name);
    User findFirstByActivateCode(String activateCode);
}
