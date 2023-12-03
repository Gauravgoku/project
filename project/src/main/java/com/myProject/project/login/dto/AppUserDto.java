package com.myProject.project.login.dto;

import com.myProject.project.common.AbstractEntityInfo;


public class AppUserDto extends AbstractEntityInfo {

    private String appUserId;
    private String name;
    private String password;
    private String phone;
    private String email;

    public AppUserDto(){

    }

    public AppUserDto(Long dateCreated, Long lastModified, String createdBy, String lastModifiedBy, Boolean isDeleted,
        String appUserId, String name, String password, String phone, String email) {
        super(dateCreated, lastModified, createdBy, lastModifiedBy, isDeleted);
        this.appUserId = appUserId;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        AppUserIdStep withIsDeleted(Boolean isDeleted);
    }

    public static interface AppUserIdStep {
        NameStep withAppUserId(String appUserId);
    }

    public static interface NameStep {
        PasswordStep withName(String name);
    }

    public static interface PasswordStep {
        PhoneStep withPassword(String password);
    }

    public static interface PhoneStep {
        EmailStep withPhone(String phone);
    }

    public static interface EmailStep {
        BuildStep withEmail(String email);
    }

    public static interface BuildStep {
        AppUserDto build();
    }

    public static class Builder
        implements DateCreatedStep, LastModifiedStep, CreatedByStep, LastModifiedByStep, IsDeletedStep, AppUserIdStep,
        NameStep, PasswordStep, PhoneStep, EmailStep, BuildStep {
        private Long dateCreated;
        private Long lastModified;
        private String createdBy;
        private String lastModifiedBy;
        private Boolean isDeleted;
        private String appUserId;
        private String name;
        private String password;
        private String phone;
        private String email;

        private Builder() {
        }

        public static DateCreatedStep appUserDto() {
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
        public AppUserIdStep withIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public NameStep withAppUserId(String appUserId) {
            this.appUserId = appUserId;
            return this;
        }

        @Override
        public PasswordStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public PhoneStep withPassword(String password) {
            this.password = password;
            return this;
        }

        @Override
        public EmailStep withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        @Override
        public BuildStep withEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public AppUserDto build() {
            return new AppUserDto(
                this.dateCreated,
                this.lastModified,
                this.createdBy,
                this.lastModifiedBy,
                this.isDeleted,
                this.appUserId,
                this.name,
                this.password,
                this.phone,
                this.email
            );
        }
    }
}
