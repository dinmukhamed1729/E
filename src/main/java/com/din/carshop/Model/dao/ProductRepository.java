package com.din.carshop.Model.dao;

import com.din.carshop.Model.entyties.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
