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
public class PaymentResponse {

    private Long id;
    private Long rentId;
    private BigDecimal amount;
    private String currency;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime paymentDate;
    private Status status;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdDate;
    private String createdBy;
}
