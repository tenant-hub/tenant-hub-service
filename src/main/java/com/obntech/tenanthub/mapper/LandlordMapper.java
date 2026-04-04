package com.obntech.tenanthub.mapper;

import com.obntech.tenanthub.dto.response.LandlordResponse;
import com.obntech.tenanthub.entity.LandlordEntity;
import org.springframework.stereotype.Component;

@Component
public class LandlordMapper {

    public LandlordResponse toResponse(LandlordEntity entity) {
        return LandlordResponse.builder()
                .id(entity.getId())
                .usersId(entity.getUser().getId())
                .usersFullName(entity.getUser().getFirstName() + " " + entity.getUser().getLastName())
                .status(entity.getStatus())
                .createdDate(entity.getCreatedDate())
                .createdBy(entity.getCreatedBy())
                .build();
    }
}
