package com.myProject.project.login.domain;

import com.myProject.project.common.AbstractAuditingEntity;

import javax.persistence.*;

@Entity
@Table(name = "appUser")
public class AppUser extends AbstractAuditingEntity {

    @Column(name = "appUserId", nullable = false)
    private String appUserId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public AppUser() {
    }

    public AppUser(String lastModifiedBy, long lastModified, String createdBy, long dateCreated, boolean isDeleted,
        String appUserId, String name, String password, String phone, String email) {
        super(lastModifiedBy, lastModified, createdBy, dateCreated, isDeleted);
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
        AppUserIdStep withIsDeleted(boolean isDeleted);
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
        AppUser build();
    }

    public static class Builder
        implements LastModifiedByStep, LastModifiedStep, CreatedByStep, DateCreatedStep, IsDeletedStep, AppUserIdStep,
        NameStep, PasswordStep, PhoneStep, EmailStep, BuildStep {
        private String lastModifiedBy;
        private long lastModified;
        private String createdBy;
        private long dateCreated;
        private boolean isDeleted;
        private String appUserId;
        private String name;
        private String password;
        private String phone;
        private String email;

        private Builder() {
        }

        public static LastModifiedByStep appUser() {
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
        public AppUserIdStep withIsDeleted(boolean isDeleted) {
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
        public AppUser build() {
            return new AppUser(
                this.lastModifiedBy,
                this.lastModified,
                this.createdBy,
                this.dateCreated,
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