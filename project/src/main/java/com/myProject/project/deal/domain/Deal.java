package com.myProject.project.deal.domain;

import com.myProject.project.common.AbstractAuditingEntity;

import javax.persistence.*;
@Entity
@Table(name = "deal")
public class Deal extends AbstractAuditingEntity {

    @Column(name = "dealId", nullable = false, unique = true)
    private String dealId;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "product", nullable = false)
    private String product;
    @Column(name = "dealValue", nullable = false)
    private Double dealValue;

    public Deal() {}

    public Deal(String lastModifiedBy, long lastModified, String createdBy, long dateCreated, boolean isDeleted,
        String dealId, String state, String city, String product, Double dealValue) {
        super(lastModifiedBy, lastModified, createdBy, dateCreated, isDeleted);
        this.dealId = dealId;
        this.state = state;
        this.city = city;
        this.product = product;
        this.dealValue = dealValue;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getDealValue() {
        return dealValue;
    }

    public void setDealValue(Double dealValue) {
        this.dealValue = dealValue;
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
        DealIdStep withIsDeleted(boolean isDeleted);
    }

    public static interface DealIdStep {
        StateStep withDealId(String dealId);
    }

    public static interface StateStep {
        CityStep withState(String state);
    }

    public static interface CityStep {
        ProductStep withCity(String city);
    }

    public static interface ProductStep {
        DealValueStep withProduct(String product);
    }

    public static interface DealValueStep {
        BuildStep withDealValue(Double dealValue);
    }

    public static interface BuildStep {
        Deal build();
    }

    public static class Builder
        implements LastModifiedByStep, LastModifiedStep, CreatedByStep, DateCreatedStep, IsDeletedStep, DealIdStep,
        StateStep, CityStep, ProductStep, DealValueStep, BuildStep {
        private String lastModifiedBy;
        private long lastModified;
        private String createdBy;
        private long dateCreated;
        private boolean isDeleted;
        private String dealId;
        private String state;
        private String city;
        private String product;
        private Double dealValue;

        private Builder() {
        }

        public static LastModifiedByStep deal() {
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
        public DealIdStep withIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public StateStep withDealId(String dealId) {
            this.dealId = dealId;
            return this;
        }

        @Override
        public CityStep withState(String state) {
            this.state = state;
            return this;
        }

        @Override
        public ProductStep withCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public DealValueStep withProduct(String product) {
            this.product = product;
            return this;
        }

        @Override
        public BuildStep withDealValue(Double dealValue) {
            this.dealValue = dealValue;
            return this;
        }

        @Override
        public Deal build() {
            return new Deal(
                this.lastModifiedBy,
                this.lastModified,
                this.createdBy,
                this.dateCreated,
                this.isDeleted,
                this.dealId,
                this.state,
                this.city,
                this.product,
                this.dealValue
            );
        }
    }
}
