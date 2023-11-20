package com.din.carshop.Model.dao;

import com.din.carshop.Model.entyties.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket,Long> {
}
