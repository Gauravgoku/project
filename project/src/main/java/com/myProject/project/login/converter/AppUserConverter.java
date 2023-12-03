package com.myProject.project.login.converter;

import com.myProject.project.login.domain.AppUser;
import com.myProject.project.login.dto.AppUserDto;
import java.util.Objects;

public class AppUserConverter {

    public AppUser convertFrom(AppUserDto appUserDto) {
        if (Objects.isNull(appUserDto)) {
            return null;
        }

        return AppUser.Builder.appUser()
            .withLastModifiedBy(appUserDto.getLastModifiedBy())
            .withLastModified(appUserDto.getLastModified())
            .withCreatedBy(appUserDto.getCreatedBy())
            .withDateCreated(appUserDto.getDateCreated())
            .withIsDeleted(appUserDto.getIsDeleted())
            .withAppUserId(appUserDto.getAppUserId())
            .withName(appUserDto.getName())
            .withPassword(appUserDto.getPassword())
            .withPhone(appUserDto.getPhone())
            .withEmail(appUserDto.getEmail())
            .build();
    }

    public AppUserDto convertTo(AppUser appUser) {
        if (Objects.isNull(appUser)) {
            return null;
        }

        return AppUserDto.Builder.appUserDto()
            .withDateCreated(appUser.getDateCreated())
            .withLastModified(appUser.getLastModified())
            .withCreatedBy(appUser.getCreatedBy())
            .withLastModifiedBy(appUser.getLastModifiedBy())
            .withIsDeleted(appUser.getIsDeleted())
            .withAppUserId(appUser.getAppUserId())
            .withName(appUser.getName())
            .withPassword(appUser.getEmail())
            .withPhone(appUser.getPhone())
            .withEmail(appUser.getEmail())
            .build();
    }
}