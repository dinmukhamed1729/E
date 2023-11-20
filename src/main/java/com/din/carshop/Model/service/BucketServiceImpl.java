package com.din.carshop.Model.service;

import com.din.carshop.Model.dao.BucketRepository;
import com.din.carshop.Model.dao.ProductRepository;
import com.din.carshop.Model.dto.BucketDTO;
import com.din.carshop.Model.dto.BucketDetailDTO;
import com.din.carshop.Model.entyties.Bucket;
import com.din.carshop.Model.entyties.Product;
import com.din.carshop.Model.entyties.User;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class BucketServiceImpl implements BucketService{
    private final BucketRepository bucketRepository;
    private final ProductRepository productRepository;
    private final UserService userService;

    public BucketServiceImpl(BucketRepository bucketRepository, ProductRepository productRepository, UserService userService) {
        this.bucketRepository = bucketRepository;
        this.productRepository = productRepository;
        this.userService = userService;
    }


    @Override
    @Transactional
    public Bucket createBucket(User user, List<Long> productsIds) {
        Bucket bucket = new Bucket();
        bucket.setUser(user);
        List<Product> products = getCollectRefProductsById(productsIds);
        bucket.setProducts(products);
        return bucketRepository.save(bucket);
    }

    private List<Product> getCollectRefProductsById(List<Long> productsIds) {
        return productsIds.stream()
                .map(productRepository::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public void addProducts(Bucket bucket, List<Long> productsIds) {
        List<Product> products = bucket.getProducts();
        List<Product> newProducts = products == null ? new ArrayList<>() : new ArrayList<>(products);
        newProducts.addAll(getCollectRefProductsById(productsIds));
        bucket.setProducts(newProducts);
        bucketRepository.save(bucket);
    }

    @Override
    public BucketDTO getBucketByUser(String name) {
        User user = userService.findByName(name);
        if(user == null || user.getBucket() == null){
            return new BucketDTO();
        }

        BucketDTO bucketDTO = new BucketDTO();
        Map<Long, BucketDetailDTO> mapByProductId = new HashMap<>();

        List<Product> products  = user.getBucket().getProducts();
        for(var product : products){
            var detail = mapByProductId.get(product.getId());
            if(detail == null) {
                mapByProductId.put(product.getId(),new BucketDetailDTO(product));
            }else{
                detail.setAmount(detail.getAmount().add(new BigDecimal("1.0")));
                detail.setSum(detail.getSum() + Double.parseDouble(product.getPrice().toString()));
            }
        }
        bucketDTO.setBucketDetails(new ArrayList<>(mapByProductId.values()));
        bucketDTO.aggregate();
        return bucketDTO;
    }

}
