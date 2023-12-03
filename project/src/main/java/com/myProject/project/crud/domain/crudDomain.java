package com.myProject.project.crud.domain;


//import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name="crud")
public class crudDomain {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private Integer id;
@Column(name="crudId")
private String crudId;
@Column(name="crudName")
private String crudName;
@Column(name="crudOccupation")
private String crudOccupation;
@Column(name="crudAge")
private Integer crudAge;

    public crudDomain() {
    }

    public crudDomain(Integer id, String crudId, String crudName, String crudOccupation, Integer crudAge) {
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
        crudDomain build();
    }

    public static class Builder implements IdStep, CrudIdStep, CrudNameStep, CrudOccupationStep, CrudAgeStep, BuildStep {
        private Integer id;
        private String crudId;
        private String crudName;
        private String crudOccupation;
        private Integer crudAge;

        private Builder() {
        }

        public static IdStep crudDomain() {
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
        public crudDomain build() {
            return new crudDomain(
                    this.id,
                    this.crudId,
                    this.crudName,
                    this.crudOccupation,
                    this.crudAge
            );
        }
    }
}
