package com.myProject.project.product.service;


import com.myProject.project.product.enums.Category;
import com.myProject.project.product.dto.ProductDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {



    Page<ProductDto> getAll(int page, int pageSize) throws ChangeSetPersister.NotFoundException;

    ProductDto getBySkuId(String skuId);

    ProductDto saveOrUpdate(ProductDto productDto);

    List<ProductDto> updateOrUploadProductUsingFile(MultipartFile file) throws IOException;

    List<ProductDto> getCategory(Category category);

    List<ProductDto> filterProducts(String productName, String itemName, Pageable pageable);

}
