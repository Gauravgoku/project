package com.myProject.project.deal.dto;


import com.myProject.project.common.AbstractEntityInfo;

public class DealDto extends AbstractEntityInfo {

    private String dealId;
    private String state;
    private String city;
    private String product;
    private Double dealValue;


    public DealDto() {
    }

    public DealDto(Long dateCreated, Long lastModified, String createdBy, String lastModifiedBy, Boolean isDeleted,
        String dealId, String state, String city, String product, Double dealValue) {
        super(dateCreated, lastModified, createdBy, lastModifiedBy, isDeleted);
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
        DealIdStep withIsDeleted(Boolean isDeleted);
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
        DealDto build();
    }

    public static class Builder
        implements DateCreatedStep, LastModifiedStep, CreatedByStep, LastModifiedByStep, IsDeletedStep, DealIdStep,
        StateStep, CityStep, ProductStep, DealValueStep, BuildStep {
        private Long dateCreated;
        private Long lastModified;
        private String createdBy;
        private String lastModifiedBy;
        private Boolean isDeleted;
        private String dealId;
        private String state;
        private String city;
        private String product;
        private Double dealValue;

        private Builder() {
        }

        public static DateCreatedStep dealDto() {
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
        public DealIdStep withIsDeleted(Boolean isDeleted) {
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
        public DealDto build() {
            return new DealDto(
                this.dateCreated,
                this.lastModified,
                this.createdBy,
                this.lastModifiedBy,
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



