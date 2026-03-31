package com.obntech.tenanthub.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.obntech.tenanthub.enums.PermissionAction;
import com.obntech.tenanthub.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionResponse {

    private Long id;
    private String name;
    private String description;
    private String module;
    private PermissionAction action;
    private Status status;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdDate;
    private String createdBy;
}
