package com.myProject.project.login.services;

import com.myProject.project.login.dto.AppUserDto;

import java.util.List;

public interface LoginService {
    AppUserDto createUser(AppUserDto user);

    AppUserDto getUserByEmail(String e_mail);

    List<AppUserDto> getAllUsers();

    AppUserDto saveOrUpdateUser(AppUserDto user);
}