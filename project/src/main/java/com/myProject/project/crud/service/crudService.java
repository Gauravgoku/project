package com.myProject.project.crud.service;

import com.myProject.project.crud.domainDto.crudDomainDto;

public interface crudService {
    crudDomainDto saveUser(crudDomainDto crudDomainDto);

    crudDomainDto updateUser(crudDomainDto crudDomainDto);

    crudDomainDto getUser(String crudName);

    crudDomainDto userDelete(String crudId);
}
