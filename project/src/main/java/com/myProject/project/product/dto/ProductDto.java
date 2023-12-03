package com.myProject.project.product.dto;

import com.myProject.project.product.enums.Category;
import com.myProject.project.common.AbstractEntityInfo;


public class ProductDto extends AbstractEntityInfo {


    private String skuId;
    private String productId;
    private String productName;
    private String productImage;
    private Integer productQuantity;
    private Double productLastPrice;
    private Double productDealPrice;
    private Double productEndPrice;
    private String itemName;
    private String hsn;
    private  String modelNumber;
    private String description;
    private Category category;

    public ProductDto() {

    }

    public ProductDto(Long dateCreated, Long lastModified, String createdBy, String lastModifiedBy, Boolean isDeleted,
        String skuId, String productId, String productName, String productImage, Integer productQuantity,
        Double productLastPrice, Double productDealPrice, Double productEndPrice, String itemName, String hsn,
        String modelNumber, String description, Category category) {
        super(dateCreated, lastModified, createdBy, lastModifiedBy, isDeleted);
        this.skuId = skuId;
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.productLastPrice = productLastPrice;
        this.productDealPrice = productDealPrice;
        this.productEndPrice = productEndPrice;
        this.itemName = itemName;
        this.hsn = hsn;
        this.modelNumber = modelNumber;
        this.description = description;
        this.category = category;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductLastPrice() {
        return productLastPrice;
    }

    public void setProductLastPrice(Double productLastPrice) {
        this.productLastPrice = productLastPrice;
    }

    public Double getProductDealPrice() {
        return productDealPrice;
    }

    public void setProductDealPrice(Double productDealPrice) {
        this.productDealPrice = productDealPrice;
    }

    public Double getProductEndPrice() {
        return productEndPrice;
    }

    public void setProductEndPrice(Double productEndPrice) {
        this.productEndPrice = productEndPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static interface DateCreatedStep {
        LastModifiedStep withDateCreated(Long dateCreated);
    }

    public static interface LastModifiedStep {
        CreatedByStep withLastModified(Long lastModified);
    }

    public static interface CreatedByStep {
        LastModifiedByStep withCreatedBy(String createdBy);
    }

    public static interface LastModifiedByStep {
        IsDeletedStep withLastModifiedBy(String lastModifiedBy);
    }

    public static interface IsDeletedStep {
        SkuIdStep withIsDeleted(Boolean isDeleted);
    }

    public static interface SkuIdStep {
        ProductIdStep withSkuId(String skuId);
    }

    public static interface ProductIdStep {
        ProductNameStep withProductId(String productId);
    }

    public static interface ProductNameStep {
        ProductImageStep withProductName(String productName);
    }

    public static interface ProductImageStep {
        ProductQuantityStep withProductImage(String productImage);
    }

    public static interface ProductQuantityStep {
        ProductLastPriceStep withProductQuantity(Integer productQuantity);
    }

    public static interface ProductLastPriceStep {
        ProductDealPriceStep withProductLastPrice(Double productLastPrice);
    }

    public static interface ProductDealPriceStep {
        ProductEndPriceStep withProductDealPrice(Double productDealPrice);
    }

    public static interface ProductEndPriceStep {
        ItemNameStep withProductEndPrice(Double productEndPrice);
    }

    public static interface ItemNameStep {
        HsnStep withItemName(String itemName);
    }

    public static interface HsnStep {
        ModelNumberStep withHsn(String hsn);
    }

    public static interface ModelNumberStep {
        DescriptionStep withModelNumber(String modelNumber);
    }

    public static interface DescriptionStep {
        CategoryStep withDescription(String description);
    }

    public static interface CategoryStep {
        BuildStep withCategory(Category category);
    }

    public static interface BuildStep {
        ProductDto build();
    }

    public static class Builder
        implements DateCreatedStep, LastModifiedStep, CreatedByStep, LastModifiedByStep, IsDeletedStep, SkuIdStep,
        ProductIdStep, ProductNameStep, ProductImageStep, ProductQuantityStep, ProductLastPriceStep,
        ProductDealPriceStep, ProductEndPriceStep, ItemNameStep, HsnStep, ModelNumberStep, DescriptionStep,
        CategoryStep, BuildStep {
        private Long dateCreated;
        private Long lastModified;
        private String createdBy;
        private String lastModifiedBy;
        private Boolean isDeleted;
        private String skuId;
        private String productId;
        private String productName;
        private String productImage;
        private Integer productQuantity;
        private Double productLastPrice;
        private Double productDealPrice;
        private Double productEndPrice;
        private String itemName;
        private String hsn;
        private String modelNumber;
        private String description;
        private Category category;

        private Builder() {
        }

        public static DateCreatedStep productDto() {
            return new Builder();
        }

        @Override
        public LastModifiedStep withDateCreated(Long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public CreatedByStep withLastModified(Long lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        @Override
        public LastModifiedByStep withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        @Override
        public IsDeletedStep withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        @Override
        public SkuIdStep withIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public ProductIdStep withSkuId(String skuId) {
            this.skuId = skuId;
            return this;
        }

        @Override
        public ProductNameStep withProductId(String productId) {
            this.productId = productId;
            return this;
        }

        @Override
        public ProductImageStep withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        @Override
        public ProductQuantityStep withProductImage(String productImage) {
            this.productImage = productImage;
            return this;
        }

        @Override
        public ProductLastPriceStep withProductQuantity(Integer productQuantity) {
            this.productQuantity = productQuantity;
            return this;
        }

        @Override
        public ProductDealPriceStep withProductLastPrice(Double productLastPrice) {
            this.productLastPrice = productLastPrice;
            return this;
        }

        @Override
        public ProductEndPriceStep withProductDealPrice(Double productDealPrice) {
            this.productDealPrice = productDealPrice;
            return this;
        }

        @Override
        public ItemNameStep withProductEndPrice(Double productEndPrice) {
            this.productEndPrice = productEndPrice;
            return this;
        }

        @Override
        public HsnStep withItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        @Override
        public ModelNumberStep withHsn(String hsn) {
            this.hsn = hsn;
            return this;
        }

        @Override
        public DescriptionStep withModelNumber(String modelNumber) {
            this.modelNumber = modelNumber;
            return this;
        }

        @Override
        public CategoryStep withDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public BuildStep withCategory(Category category) {
            this.category = category;
            return this;
        }

        @Override
        public ProductDto build() {
            return new ProductDto(
                this.dateCreated,
                this.lastModified,
                this.createdBy,
                this.lastModifiedBy,
                this.isDeleted,
                this.skuId,
                this.productId,
                this.productName,
                this.productImage,
                this.productQuantity,
                this.productLastPrice,
                this.productDealPrice,
                this.productEndPrice,
                this.itemName,
                this.hsn,
                this.modelNumber,
                this.description,
                this.category
            );
        }
    }
}

