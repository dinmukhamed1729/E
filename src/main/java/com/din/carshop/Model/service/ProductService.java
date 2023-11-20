package com.din.carshop.Model.service;

import com.din.carshop.Model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    void addToUserBucket(Long productId,String username);
}
