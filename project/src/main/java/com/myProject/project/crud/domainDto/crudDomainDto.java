package com.myProject.project.crud.domainDto;

public class crudDomainDto {

    private Integer id;
    private String crudId;
    private String crudName;
    private String crudOccupation;
    private Integer crudAge;

    public crudDomainDto() {
    }

    public crudDomainDto(Integer id, String crudId, String crudName, String crudOccupation, Integer crudAge) {
        this.id = id;
        this.crudId = crudId;
        this.crudName = crudName;
        this.crudOccupation = crudOccupation;
        this.crudAge = crudAge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrudId() {
        return crudId;
    }

    public void setCrudId(String crudId) {
        this.crudId = crudId;
    }

    public String getCrudName() {
        return crudName;
    }

    public void setCrudName(String crudName) {
        this.crudName = crudName;
    }

    public String getCrudOccupation() {
        return crudOccupation;
    }

    public void setCrudOccupation(String crudOccupation) {
        this.crudOccupation = crudOccupation;
    }

    public Integer getCrudAge() {
        return crudAge;
    }

    public void setCrudAge(Integer crudAge) {
        this.crudAge = crudAge;
    }

    public static interface IdStep {
        CrudIdStep withId(Integer id);
    }

    public static interface CrudIdStep {
        CrudNameStep withCrudId(String crudId);
    }

    public static interface CrudNameStep {
        CrudOccupationStep withCrudName(String crudName);
    }

    public static interface CrudOccupationStep {
        CrudAgeStep withCrudOccupation(String crudOccupation);
    }

    public static interface CrudAgeStep {
        BuildStep withCrudAge(Integer crudAge);
    }

    public static interface BuildStep {
        crudDomainDto build();
    }

    public static class Builder implements IdStep, CrudIdStep, CrudNameStep, CrudOccupationStep, CrudAgeStep, BuildStep {
        private Integer id;
        private String crudId;
        private String crudName;
        private String crudOccupation;
        private Integer crudAge;

        private Builder() {
        }

        public static IdStep crudDomainDto() {
            return new Builder();
        }

        @Override
        public CrudIdStep withId(Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public CrudNameStep withCrudId(String crudId) {
            this.crudId = crudId;
            return this;
        }

        @Override
        public CrudOccupationStep withCrudName(String crudName) {
            this.crudName = crudName;
            return this;
        }

        @Override
        public CrudAgeStep withCrudOccupation(String crudOccupation) {
            this.crudOccupation = crudOccupation;
            return this;
        }

        @Override
        public BuildStep withCrudAge(Integer crudAge) {
            this.crudAge = crudAge;
            return this;
        }

        @Override
        public crudDomainDto build() {
            return new crudDomainDto(
                    this.id,
                    this.crudId,
                    this.crudName,
                    this.crudOccupation,
                    this.crudAge
            );
        }
    }
}
