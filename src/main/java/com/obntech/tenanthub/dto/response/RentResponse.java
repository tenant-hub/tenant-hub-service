package com.obntech.tenanthub.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.obntech.tenanthub.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentResponse {

    private Long id;
    private Long realEstateId;
    private String realEstateName;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime rentDate;
    private BigDecimal rentAmount;
    private String currency;
    private BigDecimal increaseRate;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime paymentDueDate;
    private Status status;
    private String note;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdDate;
    private String createdBy;
}
