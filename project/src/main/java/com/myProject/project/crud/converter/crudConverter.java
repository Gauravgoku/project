package com.myProject.project.crud.converter;

import com.myProject.project.crud.domain.crudDomain;
import com.myProject.project.crud.domainDto.crudDomainDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class crudConverter {

public crudDomain convertFrom(crudDomainDto crudDomainDto){

    if(Objects.isNull(crudDomainDto)){
         return null;
    }
    return crudDomain.Builder.crudDomain()
            .withId(null)
            .withCrudId(crudDomainDto.getCrudId())
            .withCrudName(crudDomainDto.getCrudName())
            .withCrudOccupation(crudDomainDto.getCrudOccupation())
            .withCrudAge(crudDomainDto.getCrudAge())
            .build();
}

public crudDomainDto convertTo(crudDomain crudDomain){

   if(Objects.isNull(crudDomain)){
      return null;
   }
   return crudDomainDto.Builder.crudDomainDto()
           .withId(crudDomain.getId())
           .withCrudId(crudDomain.getCrudId())
           .withCrudName(crudDomain.getCrudName())
           .withCrudOccupation(crudDomain.getCrudOccupation())
           .withCrudAge(crudDomain.getCrudAge())
           .build();
}
}
