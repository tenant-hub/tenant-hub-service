package com.obntech.tenanthub.mapper;

import com.obntech.tenanthub.dto.response.TenantResponse;
import com.obntech.tenanthub.entity.TenantEntity;
import org.springframework.stereotype.Component;

@Component
public class TenantMapper {

    public TenantResponse toResponse(TenantEntity entity) {
        return TenantResponse.builder()
                .id(entity.getId())
                .usersId(entity.getUser().getId())
                .usersFullName(entity.getUser().getFirstName() + " " + entity.getUser().getLastName())
                .status(entity.getStatus())
                .createdDate(entity.getCreatedDate())
                .createdBy(entity.getCreatedBy())
                .build();
    }
}
