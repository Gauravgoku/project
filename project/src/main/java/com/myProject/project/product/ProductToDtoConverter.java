package com.myProject.project.product;

import com.myProject.project.product.domain.Product;
import com.myProject.project.product.dto.ProductDto;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class ProductToDtoConverter {

    public Product convertFrom(ProductDto productDto) {

        if (Objects.isNull(productDto)) {
            return null;
        }

        return Product.Builder.product()
            .withLastModifiedBy(productDto.getLastModifiedBy())
            .withLastModified(productDto.getLastModified())
            .withCreatedBy(productDto.getCreatedBy())
            .withDateCreated(productDto.getDateCreated())
            .withIsDeleted(productDto.getIsDeleted())
            .withSkuId(productDto.getSkuId())
            .withProductId(productDto.getProductId())
            .withProductName(productDto.getProductName())
            .withProductImage(productDto.getProductImage())
            .withProductQuantity(productDto.getProductQuantity())
            .withProductLastPrice(productDto.getProductLastPrice())
            .withProductDealPrice(productDto.getProductDealPrice())
            .withProductEndPrice(productDto.getProductEndPrice())
            .withItemName(productDto.getItemName())
            .withHsn(productDto.getHsn())
            .withModelNumber(productDto.getModelNumber())
            .withDescription(productDto.getDescription())
            .withCategory(productDto.getCategory())
            .build();
    }

    public ProductDto convertTo(Product product) {

        if (Objects.isNull(product)) {
            return null;
        }

        return ProductDto.Builder.productDto()
            .withDateCreated(product.getDateCreated())
            .withLastModified(product.getLastModified())
            .withCreatedBy(product.getCreatedBy())
            .withLastModifiedBy(product.getLastModifiedBy())
            .withIsDeleted(product.getIsDeleted())
            .withSkuId(product.getSkuId())
            .withProductId(product.getProductId())
            .withProductName(product.getProductName())
            .withProductImage(product.getProductImage())
            .withProductQuantity(product.getProductQuantity())
            .withProductLastPrice(product.getProductLastPrice())
            .withProductDealPrice(product.getProductDealPrice())
            .withProductEndPrice(product.getProductEndPrice())
            .withItemName(product.getItemName())
            .withHsn(product.getHsn())
            .withModelNumber(product.getModelNumber())
            .withDescription(product.getDescription())
            .withCategory(product.getCategory())
            .build();
    }
}








