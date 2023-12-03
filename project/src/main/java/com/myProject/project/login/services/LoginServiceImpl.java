package com.myProject.project.login.services;

import com.myProject.project.Constants;
import com.myProject.project.login.domain.AppUser;
import com.myProject.project.login.repositories.AppUserRepository;
import com.myProject.project.login.dto.AppUserDto;
import com.myProject.project.login.converter.AppUserConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    private AppUserRepository appUserRepository;

    Long currentTime = System.currentTimeMillis();

    String constantsValues = Constants.SYSTEM;

    private AppUserConverter converter = new AppUserConverter();

    @Override
    public AppUserDto createUser(AppUserDto appUserDto) {

        AppUser user = converter.convertFrom(appUserDto);

        AppUser savedUser = appUserRepository.save(user);

        AppUserDto savedAppUserDto = converter.convertTo(savedUser);

        return savedAppUserDto;
    }

    @Override
    public AppUserDto getUserByEmail(String eMail) {
        AppUser user = appUserRepository.findByEmail(eMail);
        return converter.convertTo(user);
    }

    @Override
    public List<AppUserDto> getAllUsers() {
        List<AppUser> users = appUserRepository.findAll();
        return users.stream().map(converter::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDto saveOrUpdateUser(AppUserDto user) {
        AppUser appUser = appUserRepository.findByEmail(user.getEmail());

        if (Objects.isNull(appUser)) {
            appUser = converter.convertFrom(user);
            appUser.setId(Long.valueOf(UUID.randomUUID().toString()));
            appUser.setDateCreated(currentTime);
            appUser.setCreatedBy(constantsValues);
        }
        else {
            if (Objects.nonNull(appUser.getEmail())) {
                appUser.setEmail(appUser.getEmail());
            }
            if (Objects.nonNull(appUser.getName())) {
                appUser.setName(appUser.getName());
            }
            if (Objects.nonNull(appUser.getPhone())) {
                appUser.setPhone(appUser.getPhone());
            }
            if (Objects.nonNull(appUser.getPassword())) {
                appUser.setPassword(appUser.getPassword());
            }
        }

        appUser.setLastModified(currentTime);
        appUser.setLastModifiedBy(constantsValues);

        appUser = appUserRepository.save(appUser);

        return converter.convertTo(appUser);
    }
}
