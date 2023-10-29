package com.myProject.project.crud.service;

import com.myProject.project.crud.domain.crudDomain;
import com.myProject.project.crud.domainDto.crudDomainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class crudServiceImpl implements crudService {

    @Autowired
    private com.myProject.project.crud.repository.crudRepository crudRepository;
    @Autowired
    private com.myProject.project.crud.converter.crudConverter crudConverter;

    @Override
    public crudDomainDto saveUser(crudDomainDto crudDomainDto) {
        crudDomain crudDomain = crudConverter.convertFrom(crudDomainDto);
        crudDomain = crudRepository.save(crudDomain);
        crudDomainDto crudDomainDto1 = crudConverter.convertTo(crudDomain);
        return crudDomainDto1;
    }

    @Override
    public crudDomainDto updateUser(crudDomainDto crudDomainDto) {
        crudDomain crudDomain = crudRepository.findByCrudId(crudDomainDto.getCrudId());
        if (Objects.isNull(crudDomain)) {
            crudDomain = crudConverter.convertFrom(crudDomainDto);
        } else {
            if (Objects.nonNull(crudDomainDto.getCrudName())) {
                crudDomain.setCrudName(crudDomainDto.getCrudName());
            }
            if (Objects.nonNull(crudDomainDto.getCrudOccupation())) {
                crudDomain.setCrudOccupation(crudDomainDto.getCrudOccupation());
            }
            if (Objects.nonNull(crudDomainDto.getCrudAge())) {
                crudDomain.setCrudAge(crudDomainDto.getCrudAge());
            }
        }
        crudDomain = crudRepository.save(crudDomain);
        return crudConverter.convertTo(crudDomain);
    }

    @Override
    public crudDomainDto getUser(String crudName) {
        crudDomain crudDomain = crudRepository.findByName(crudName);
        crudDomainDto crudDomainDto = crudConverter.convertTo(crudDomain);
        return crudDomainDto;
    }

    @Override
    public crudDomainDto userDelete(String crudId) {
        crudDomain crudDomain=crudRepository.userDelete(crudId);
        crudDomainDto crudDomainDto=crudConverter.convertTo(crudDomain);
        return crudDomainDto;
    }



    }
