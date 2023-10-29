package com.myProject.project.inventory.dto;


import com.myProject.project.common.AbstractEntityInfo;

public class InventoryDto extends AbstractEntityInfo {

    private String itemId;
    private String itemName;
    private String itemImage;
    private Double itemValue;
    private String itemModelNumber;
    private String buyerName;
    private String sellerName;
    private long deliverItemDate;
    private long receiveItemDate;
    private String emptyItem;

    public InventoryDto() {
    }

    public InventoryDto(Long dateCreated, Long lastModified, String createdBy, String lastModifiedBy, Boolean isDeleted, String itemId, String itemName, String itemImage, Double itemValue, String itemModelNumber, String buyerName, String sellerName, long deliverItemDate, long receiveItemDate, String emptyItem) {
        super(dateCreated, lastModified, createdBy, lastModifiedBy, isDeleted);
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemValue = itemValue;
        this.itemModelNumber = itemModelNumber;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.deliverItemDate = deliverItemDate;
        this.receiveItemDate = receiveItemDate;
        this.emptyItem = emptyItem;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public Double getItemValue() {
        return itemValue;
    }

    public void setItemValue(Double itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemModelNumber() {
        return itemModelNumber;
    }

    public void setItemModelNumber(String itemModelNumber) {
        this.itemModelNumber = itemModelNumber;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public long getDeliverItemDate() {
        return deliverItemDate;
    }

    public void setDeliverItemDate(long deliverItemDate) {
        this.deliverItemDate = deliverItemDate;
    }

    public long getReceiveItemDate() {
        return receiveItemDate;
    }

    public void setReceiveItemDate(long receiveItemDate) {
        this.receiveItemDate = receiveItemDate;
    }

    public String getEmptyItem() {
        return emptyItem;
    }

    public void setEmptyItem(String emptyItem) {
        this.emptyItem = emptyItem;
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
        ItemIdStep withIsDeleted(Boolean isDeleted);
    }

    public static interface ItemIdStep {
        ItemNameStep withItemId(String itemId);
    }

    public static interface ItemNameStep {
        ItemImageStep withItemName(String itemName);
    }

    public static interface ItemImageStep {
        ItemValueStep withItemImage(String itemImage);
    }

    public static interface ItemValueStep {
        ItemModelNumberStep withItemValue(Double itemValue);
    }

    public static interface ItemModelNumberStep {
        BuyerNameStep withItemModelNumber(String itemModelNumber);
    }

    public static interface BuyerNameStep {
        SellerNameStep withBuyerName(String buyerName);
    }

    public static interface SellerNameStep {
        DeliverItemDateStep withSellerName(String sellerName);
    }

    public static interface DeliverItemDateStep {
        ReceiveItemDateStep withDeliverItemDate(long deliverItemDate);
    }

    public static interface ReceiveItemDateStep {
        EmptyItemStep withReceiveItemDate(long receiveItemDate);
    }

    public static interface EmptyItemStep {
        BuildStep withEmptyItem(String emptyItem);
    }

    public static interface BuildStep {
        InventoryDto build();
    }

    public static class Builder implements DateCreatedStep, LastModifiedStep, CreatedByStep, LastModifiedByStep, IsDeletedStep, ItemIdStep, ItemNameStep, ItemImageStep, ItemValueStep, ItemModelNumberStep, BuyerNameStep, SellerNameStep, DeliverItemDateStep, ReceiveItemDateStep, EmptyItemStep, BuildStep {
        private Long dateCreated;
        private Long lastModified;
        private String createdBy;
        private String lastModifiedBy;
        private Boolean isDeleted;
        private String itemId;
        private String itemName;
        private String itemImage;
        private Double itemValue;
        private String itemModelNumber;
        private String buyerName;
        private String sellerName;
        private long deliverItemDate;
        private long receiveItemDate;
        private String emptyItem;

        private Builder() {
        }

        public static DateCreatedStep inventoryDto() {
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
        public ItemIdStep withIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public ItemNameStep withItemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        @Override
        public ItemImageStep withItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        @Override
        public ItemValueStep withItemImage(String itemImage) {
            this.itemImage = itemImage;
            return this;
        }

        @Override
        public ItemModelNumberStep withItemValue(Double itemValue) {
            this.itemValue = itemValue;
            return this;
        }

        @Override
        public BuyerNameStep withItemModelNumber(String itemModelNumber) {
            this.itemModelNumber = itemModelNumber;
            return this;
        }

        @Override
        public SellerNameStep withBuyerName(String buyerName) {
            this.buyerName = buyerName;
            return this;
        }

        @Override
        public DeliverItemDateStep withSellerName(String sellerName) {
            this.sellerName = sellerName;
            return this;
        }

        @Override
        public ReceiveItemDateStep withDeliverItemDate(long deliverItemDate) {
            this.deliverItemDate = deliverItemDate;
            return this;
        }

        @Override
        public EmptyItemStep withReceiveItemDate(long receiveItemDate) {
            this.receiveItemDate = receiveItemDate;
            return this;
        }

        @Override
        public BuildStep withEmptyItem(String emptyItem) {
            this.emptyItem = emptyItem;
            return this;
        }

        @Override
        public InventoryDto build() {
            return new InventoryDto(
                    this.dateCreated,
                    this.lastModified,
                    this.createdBy,
                    this.lastModifiedBy,
                    this.isDeleted,
                    this.itemId,
                    this.itemName,
                    this.itemImage,
                    this.itemValue,
                    this.itemModelNumber,
                    this.buyerName,
                    this.sellerName,
                    this.deliverItemDate,
                    this.receiveItemDate,
                    this.emptyItem
            );
        }
    }
}
