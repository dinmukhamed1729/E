package com.din.carshop.mapper;

import com.din.carshop.Model.dto.ProductDTO;
import com.din.carshop.Model.entyties.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-19T20:43:18+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProduct(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( dto.getId() );
        productDTO.setTitle( dto.getTitle() );
        productDTO.setPrice( dto.getPrice() );

        return productDTO;
    }

    @Override
    public ProductDTO fromProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setTitle( product.getTitle() );
        productDTO.setPrice( product.getPrice() );

        return productDTO;
    }

    @Override
    public List<Product> toProductList(List<ProductDTO> products) {
        if ( products == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( products.size() );
        for ( ProductDTO productDTO : products ) {
            list.add( productDTOToProduct( productDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductDTO> fromProductList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( fromProduct( product ) );
        }

        return list;
    }

    protected Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setTitle( productDTO.getTitle() );
        product.setPrice( productDTO.getPrice() );

        return product;
    }
}
