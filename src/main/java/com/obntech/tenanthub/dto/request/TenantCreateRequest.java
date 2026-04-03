package com.obntech.tenanthub.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantCreateRequest {

    @NotNull(message = "Kullanıcı ID boş olamaz")
    private Long usersId;
}
