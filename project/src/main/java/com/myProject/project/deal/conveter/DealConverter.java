package com.myProject.project.deal.conveter;

import com.myProject.project.deal.domain.Deal;
import com.myProject.project.deal.dto.DealDto;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class DealConverter {

    public Deal convertFrom(DealDto dealDto) {

        if (Objects.isNull(dealDto)) {
            return null;
        }

        return Deal.Builder.deal()
            .withLastModifiedBy(dealDto.getLastModifiedBy())
            .withLastModified(dealDto.getLastModified())
            .withCreatedBy(dealDto.getCreatedBy())
            .withDateCreated(dealDto.getDateCreated())
            .withIsDeleted(dealDto.getIsDeleted())
            .withDealId(dealDto.getDealId())
            .withState(dealDto.getState())
            .withCity(dealDto.getCity())
            .withProduct(dealDto.getProduct())
            .withDealValue(dealDto.getDealValue())
            .build();
    }

    public DealDto convertTo(Deal deal) {

        if (Objects.isNull(deal)) {
            return null;
        }

        return DealDto.Builder.dealDto()
            .withDateCreated(deal.getDateCreated())
            .withLastModified(deal.getLastModified())
            .withCreatedBy(deal.getCreatedBy())
            .withLastModifiedBy(deal.getLastModifiedBy())
            .withIsDeleted(deal.getIsDeleted())
            .withDealId(deal.getDealId())
            .withState(deal.getState())
            .withCity(deal.getCity())
            .withProduct(deal.getProduct())
            .withDealValue(deal.getDealValue())
            .build();
    }
}
