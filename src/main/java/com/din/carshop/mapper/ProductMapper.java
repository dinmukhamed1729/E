package com.din.carshop.mapper;

import com.din.carshop.Model.dto.ProductDTO;
import com.din.carshop.Model.entyties.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    ProductDTO toProduct(ProductDTO dto);

    @InheritInverseConfiguration
    ProductDTO fromProduct(Product product);

    List<Product> toProductList(List<ProductDTO>products);
    List<ProductDTO> fromProductList(List<Product> products);
}
