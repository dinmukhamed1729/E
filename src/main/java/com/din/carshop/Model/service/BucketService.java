package com.din.carshop.Model.service;

import com.din.carshop.Model.dto.BucketDTO;
import com.din.carshop.Model.entyties.Bucket;
import com.din.carshop.Model.entyties.User;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productsIds);
    void addProducts(Bucket bucket,List<Long> productsIds);
    BucketDTO getBucketByUser(String name);
}
