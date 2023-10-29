package com.myProject.project.product.repository;


import com.myProject.project.product.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Page<Product> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM product WHERE skuId = ?1")
    Product findBySkuId(String skuId);

    @Query(nativeQuery = true, value = "SELECT * FROM product WHERE category = ?1")
    List<Product> findByCategory(String category);

    List<Product> findAll(Specification<Product> filters, Pageable pageable);
}
