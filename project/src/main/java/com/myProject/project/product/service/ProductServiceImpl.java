package com.myProject.project.product.service;


import com.myProject.project.Constants;
import com.myProject.project.product.domain.Product;
import com.myProject.project.product.enums.Category;
import com.myProject.project.product.repository.ProductRepository;
import com.myProject.project.product.ProductToDtoConverter;
import com.myProject.project.product.dto.ProductDto;
import javax.persistence.criteria.Predicate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wiremock.org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductToDtoConverter productToDtoConverter;

    @Override
    public ProductDto getBySkuId(String skuId) {
        Product product = productRepository.findBySkuId(skuId);
        ProductDto productDto = productToDtoConverter.convertTo(product);
        return productDto;
    }

    @Override
    public Page<ProductDto> getAll(int page, int pageSize) throws ChangeSetPersister.NotFoundException {
        Page<Product> products = productRepository.findAll(PageRequest.of(page, pageSize));
        if (Objects.isNull(products) || products.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }

        Page<ProductDto> productDtos = products.map(product -> productToDtoConverter.convertTo(product));
        return productDtos;
    }


    @Override
    public ProductDto saveOrUpdate(ProductDto productDto) {
        Product product = productRepository.findBySkuId(productDto.getSkuId());


        if (Objects.isNull(product)) {
            product = productToDtoConverter.convertFrom(productDto);
            product.setProductId(UUID.randomUUID().toString());
            product.setDateCreated(System.currentTimeMillis());
            product.setCreatedBy(Constants.SYSTEM);
        } else {
            if (Objects.nonNull(product.getProductName())) {
                product.setProductName(product.getProductName());
            }
            if (Objects.nonNull(product.getProductImage())) {
                product.setProductImage(product.getProductImage());
            }
            if (Objects.nonNull(product.getProductQuantity())) {
                product.setProductQuantity(product.getProductQuantity());
            }
            if (Objects.nonNull(product.getProductLastPrice())) {
                product.setProductLastPrice(product.getProductLastPrice());
            }
            if (Objects.nonNull(product.getProductDealPrice())) {
                product.setProductDealPrice(product.getProductDealPrice());
            }
            if (Objects.nonNull(product.getProductEndPrice())) {
                product.setProductEndPrice(product.getProductEndPrice());
            }
            if (Objects.nonNull(product.getLastModifiedBy())) {
                product.setLastModifiedBy(product.getLastModifiedBy()); //date
            }
            if (Objects.nonNull(product.getItemName())) {
                product.setItemName(product.getItemName());
            }
            if (Objects.nonNull(product.getHsn())) {
                product.setHsn(product.getHsn());
            }
            if (Objects.nonNull(product.getModelNumber())) {
                product.setModelNumber(product.getModelNumber());
            }
            if (Objects.nonNull(product.getDescription())) {
                product.setDescription(product.getDescription());
            }
            if (Objects.nonNull(product.getCategory())) {
                product.setCategory(product.getCategory());
            }
        }
        product.setLastModified(System.currentTimeMillis());
        product.setLastModifiedBy(Constants.SYSTEM);

        product = productRepository.save(product);

        return productToDtoConverter.convertTo(product);
    }

    @Override
    public List<ProductDto> updateOrUploadProductUsingFile(MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();
        List<ProductDto> productDtoList = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet workbookSheet = workbook.getSheetAt(0);

            Iterator<Row> rows = workbookSheet.iterator();
            if (!rows.hasNext()) {
                throw new IOException("Empty data in excel");
            }

            rows.next();

            DataFormatter format = new DataFormatter();

            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();

                ProductDto productDto = new ProductDto();

                int start = 1;
                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (start) {
                        case 1:
                            String skuId = format.formatCellValue(cell);  //excel data fetch in string form and return format value of a cell
                            if (StringUtils.isNotEmpty(skuId)) {        //StringUtils contain static method using string value
                                productDto.setSkuId(skuId);
                            }
                            break;
                        case 2:
                            String productName = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(productName)) {
                                productDto.setProductName(productName);
                            }
                            break;
                        case 3:
                            String productImage = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(productImage)) {
                                productDto.setProductImage(productImage);
                            }
                            break;
                        case 4:
                            if (cell.getCellType() == CellType.NUMERIC) {
                                productDto.setProductQuantity((int) cell.getNumericCellValue());

                            } else if ((cell.getCellType() == CellType.STRING)) {
                                productDto.setProductQuantity(Integer.parseInt(String.valueOf(cell.getNumericCellValue())));
                            }

                            break;
                        case 5:
                            if (cell.getCellType() == CellType.NUMERIC) {
                                productDto.setProductLastPrice((double) cell.getNumericCellValue());
                            }
                            break;
                        case 6:
                            if (cell.getCellType() == CellType.NUMERIC) {
                                productDto.setProductDealPrice((double) cell.getNumericCellValue());
                            }
                            break;
                        case 7:
                            if (cell.getCellType() == CellType.NUMERIC) {
                                productDto.setProductEndPrice((double) cell.getNumericCellValue());
                            }
                            break;
                        case 8:
                            String lastModifiedBy = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(lastModifiedBy)) {
                                productDto.setLastModifiedBy(lastModifiedBy);
                            }
                            break;
                        case 9:
                            String ItemName = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(ItemName)) {
                                productDto.setItemName(ItemName);
                            }
                            break;
                        case 11:
                            String hsn = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(hsn)) {
                                productDto.setHsn(hsn);
                            }
                            break;
                        case 12:
                            String modelNumber = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(modelNumber)) {
                                productDto.setModelNumber(modelNumber);
                            }
                            break;
                        case 13:
                            String description = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(description)) {
                                productDto.setDescription(description);
                            }
                            break;
                        case 14:
                            String category = format.formatCellValue(cell);
                            if (StringUtils.isNotEmpty(category)) {
                                try {
                                    productDto.setCategory(Category.valueOf(category));
                                } catch (IllegalArgumentException e) {
                                    throw new InvalidClassException("Invalid category value: ");
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    start++;
                }
                    productDtoList.add(productDto);
                    saveOrUpdate(productDto);
            }

        }catch(IllegalArgumentException e){
            throw new RuntimeException("Invalid value");
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> getCategory(Category category) {
        List<Product> products = productRepository.findByCategory(category.getDisplayName());
        return products.stream()
                .map(product -> productToDtoConverter.convertTo(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filterProducts(String productName, String itemName, Pageable pageable) {
        Specification<Product> filters = filter(productName,itemName);
        List<Product> products = productRepository.findAll(filters, pageable);
        return products.stream()
                .map(product -> productToDtoConverter.convertTo(product))
                .collect(Collectors.toList());
    }


    public Specification<Product> filter(String productName, String itemName){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();  //predicates is a boolean function to give value true or false

            if (productName != null || productName.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")),"%" + productName.toLowerCase() + "%"));
            } //criteriaBuilder contains preDefine method use  to define queries to fetch data
            if (itemName != null || itemName.isEmpty()) {  //lower use to value upperCase
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("itemName")),"%" + itemName.toLowerCase() + "%"));
            }  // like use to patten is satisfied then return predicates

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}




