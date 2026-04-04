package com.obntech.tenanthub.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStatsResponse {

    private Integer totalUsers;
    private Integer totalTenants;
    private Integer totalLandlords;
    private Integer totalRealEstates;
    private Integer totalRents;
    private Integer totalPayments;
    private Integer rentedRealEstates;
    private Integer vacantRealEstates;
}
