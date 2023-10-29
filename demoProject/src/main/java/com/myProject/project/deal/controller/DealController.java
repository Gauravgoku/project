package com.myProject.project.deal.controller;


import com.myProject.project.common.libs.BaseController;
import com.myProject.project.common.libs.RestResponse;
import com.myProject.project.deal.service.DealService;
import com.myProject.project.deal.dto.DealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.myProject.project.common.libs.BaseController.ok;


@RestController
@RequestMapping("/api/v1/deals")
public class DealController {

    @Autowired
    private DealService dealService;


    @PostMapping("/{dealId}")
    public ResponseEntity<RestResponse<DealDto>> updateDeal(@PathVariable("dealId") String dealId, @RequestBody DealDto dealDto) {
        DealDto dealDtos = dealService.saveOrUpdate(dealDto);
        return BaseController.ok(BaseController.newRestResponse(dealDtos));
    }
}


