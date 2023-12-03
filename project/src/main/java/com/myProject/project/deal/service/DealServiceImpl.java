package com.myProject.project.deal.service;

import com.myProject.project.deal.repository.DealRepository;
import com.myProject.project.deal.conveter.DealConverter;
import com.myProject.project.deal.domain.Deal;
import com.myProject.project.deal.dto.DealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private DealConverter dealConverter;

    @Override
    public DealDto saveOrUpdate(DealDto dealDto) {
        Deal dealDb = dealRepository.findByDealId(String.valueOf(dealDto.getDealId()));

        if (Objects.isNull(dealDb)) {
            dealDb = dealConverter.convertFrom(dealDto);
            dealDb.setDateCreated(System.currentTimeMillis());
        } else {
            if (Objects.nonNull(dealDto.getProduct())) {
                dealDb.setProduct(dealDto.getProduct());

            }
            if (Objects.nonNull(dealDto.getDealValue())) {
                dealDb.setDealValue(dealDto.getDealValue());
            }
            dealDb.setState(dealDto.getState());
            dealDb.setCity(dealDto.getCity());
        }

        dealDb.setLastModified(System.currentTimeMillis());
        return dealConverter.convertTo(dealRepository.save(dealDb));
    }

}
