package com.obntech.tenanthub.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.obntech.tenanthub.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandlordResponse {

    private Long id;
    private Long usersId;
    private String usersFullName;
    private Status status;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdDate;
    private String createdBy;
}
