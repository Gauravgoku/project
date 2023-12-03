package com.myProject.project.product.controller;


import com.myProject.project.product.utility.FileUtils;
import com.myProject.project.common.libs.BaseController;
import com.myProject.project.common.libs.RestResponse;
import com.myProject.project.product.dto.ProductDto;
import com.myProject.project.product.enums.Category;
import com.myProject.project.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;


    @GetMapping("")
    public ResponseEntity<RestResponse<List<ProductDto>>> findBySkuId(@RequestParam("sKuId") String sKuId) {
           ProductDto productDto = productService.getBySkuId(sKuId);
         return ok(newRestResponse(Collections.singletonList(productDto)));
    }


    @GetMapping("all")
    ResponseEntity<RestResponse<Page<ProductDto>>> getAll(int page, int pageSize) throws ChangeSetPersister.NotFoundException {
        Page<ProductDto> productDto = productService.getAll(page, pageSize);
        return ok(newRestResponse(productDto));
    }

    @PostMapping("")
    public ResponseEntity<RestResponse<List<ProductDto>>> updateProduct(@RequestBody ProductDto productDto) {
        ProductDto productDtos= productService.saveOrUpdate(productDto);
        return ok(newRestResponse(Collections.singletonList(productDtos)));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        } else if (FileUtils.checkFileIsExcel(file)) {
                productService.updateOrUploadProductUsingFile(file);
                return ResponseEntity.ok(Map.of("Message", "File upload and save in database").toString());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload an excel file");
    }


    @GetMapping("categories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = Category.getAllProductCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("category")
    public ResponseEntity<RestResponse<List<ProductDto>>> getProducts(@RequestParam("category") Category category) {
        List<ProductDto> productDto = productService.getCategory(category);
        return ok(newRestResponse(productDto));
    }

    @GetMapping("filter")
    public ResponseEntity<RestResponse<List<ProductDto>>> getFilterProducts(@RequestParam(required = false)String productName,
                                                              @RequestParam(required = false)String itemName,
                                                              @RequestParam(defaultValue = "0")int page,
                                                              @RequestParam(defaultValue = "5")int pageSize,
                                                              @RequestParam(required = false)String sort)
    {
        Sort sorts = Sort.by("productName").ascending();
        if (sort != null && !sort.isEmpty()) {
            sorts = Sort.by("category").ascending();
        }
        Pageable pageable = PageRequest.of(page, pageSize,sorts);
        List<ProductDto> products = productService.filterProducts(productName,itemName,pageable);
        return ok(newRestResponse(products));
    }

}
