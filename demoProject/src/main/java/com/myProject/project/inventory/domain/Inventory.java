package com.myProject.project.inventory.domain;


import com.myProject.project.common.AbstractAuditingEntity;
import javax.persistence.*;
import lombok.ToString;



@Entity
@Table(name = "inventory")
@ToString
public class Inventory extends AbstractAuditingEntity{


@Column(name="itemId",nullable = false)
private String itemId;

@Column(name="itemName")
private String itemName;

@Column(name="itemImage")
private String itemImage;

@Column(name="itemValue")
private Double itemValue;

@Column(name="itemModelNumber")
private String itemModelNumber;

@Column(name="deliverItemDate",nullable = false)
private long deliverItemDate;

@Column(name="buyerName",nullable = false)
private String buyerName;

@Column(name="sellerName",nullable = false)
private String sellerName;

@Column(name="receiveItemDate",nullable = false)
private long receiveItemDate;

@Column(name="emptyItem")
private String emptyItem;

    public Inventory() {
    }

    public Inventory(String lastModifiedBy, long lastModified, String createdBy, long dateCreated, boolean isDeleted, String itemId, String itemName, String itemImage, Double itemValue, String itemModelNumber, long deliverItemDate, String buyerName, String sellerName, long receiveItemDate, String emptyItem) {
        super(lastModifiedBy, lastModified, createdBy, dateCreated, isDeleted);
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemValue = itemValue;
        this.itemModelNumber = itemModelNumber;
        this.deliverItemDate = deliverItemDate;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
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

    public long getDeliverItemDate() {
        return deliverItemDate;
    }

    public void setDeliverItemDate(long deliverItemDate) {
        this.deliverItemDate = deliverItemDate;
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

    public static interface LastModifiedByStep {
        LastModifiedStep withLastModifiedBy(String lastModifiedBy);
    }

    public static interface LastModifiedStep {
        CreatedByStep withLastModified(long lastModified);
    }

    public static interface CreatedByStep {
        DateCreatedStep withCreatedBy(String createdBy);
    }

    public static interface DateCreatedStep {
        IsDeletedStep withDateCreated(long dateCreated);
    }

    public static interface IsDeletedStep {
        ItemIdStep withIsDeleted(boolean isDeleted);
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
        DeliverItemDateStep withItemModelNumber(String itemModelNumber);
    }

    public static interface DeliverItemDateStep {
        BuyerNameStep withDeliverItemDate(long deliverItemDate);
    }

    public static interface BuyerNameStep {
        SellerNameStep withBuyerName(String buyerName);
    }

    public static interface SellerNameStep {
        ReceiveItemDateStep withSellerName(String sellerName);
    }

    public static interface ReceiveItemDateStep {
        EmptyItemStep withReceiveItemDate(long receiveItemDate);
    }

    public static interface EmptyItemStep {
        BuildStep withEmptyItem(String emptyItem);
    }

    public static interface BuildStep {
        Inventory build();
    }

    public static class Builder implements LastModifiedByStep, LastModifiedStep, CreatedByStep, DateCreatedStep, IsDeletedStep, ItemIdStep, ItemNameStep, ItemImageStep, ItemValueStep, ItemModelNumberStep, DeliverItemDateStep, BuyerNameStep, SellerNameStep, ReceiveItemDateStep, EmptyItemStep, BuildStep {
        private String lastModifiedBy;
        private long lastModified;
        private String createdBy;
        private long dateCreated;
        private boolean isDeleted;
        private String itemId;
        private String itemName;
        private String itemImage;
        private Double itemValue;
        private String itemModelNumber;
        private long deliverItemDate;
        private String buyerName;
        private String sellerName;
        private long receiveItemDate;
        private String emptyItem;

        private Builder() {
        }

        public static LastModifiedByStep inventory() {
            return new Builder();
        }

        @Override
        public LastModifiedStep withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        @Override
        public CreatedByStep withLastModified(long lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        @Override
        public DateCreatedStep withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        @Override
        public IsDeletedStep withDateCreated(long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public ItemIdStep withIsDeleted(boolean isDeleted) {
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
        public DeliverItemDateStep withItemModelNumber(String itemModelNumber) {
            this.itemModelNumber = itemModelNumber;
            return this;
        }

        @Override
        public BuyerNameStep withDeliverItemDate(long deliverItemDate) {
            this.deliverItemDate = deliverItemDate;
            return this;
        }

        @Override
        public SellerNameStep withBuyerName(String buyerName) {
            this.buyerName = buyerName;
            return this;
        }

        @Override
        public ReceiveItemDateStep withSellerName(String sellerName) {
            this.sellerName = sellerName;
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
        public Inventory build() {
            return new Inventory(
                    this.lastModifiedBy,
                    this.lastModified,
                    this.createdBy,
                    this.dateCreated,
                    this.isDeleted,
                    this.itemId,
                    this.itemName,
                    this.itemImage,
                    this.itemValue,
                    this.itemModelNumber,
                    this.deliverItemDate,
                    this.buyerName,
                    this.sellerName,
                    this.receiveItemDate,
                    this.emptyItem
            );
        }
    }
}
