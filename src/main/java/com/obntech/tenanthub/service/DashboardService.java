package com.obntech.tenanthub.service;

import com.obntech.tenanthub.dto.response.DashboardStatsResponse;
import com.obntech.tenanthub.enums.Status;
import com.obntech.tenanthub.repository.LandlordRepository;
import com.obntech.tenanthub.repository.PaymentRepository;
import com.obntech.tenanthub.repository.RealEstateRepository;
import com.obntech.tenanthub.repository.RentRepository;
import com.obntech.tenanthub.repository.TenantRepository;
import com.obntech.tenanthub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DashboardService {

    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final LandlordRepository landlordRepository;
    private final RealEstateRepository realEstateRepository;
    private final RentRepository rentRepository;
    private final PaymentRepository paymentRepository;

    @Transactional(readOnly = true)
    public DashboardStatsResponse getStats() {
        log.info("Dashboard istatistikleri getiriliyor.");

        long totalUsers = userRepository.count();
        long totalTenants = tenantRepository.countByStatus(Status.ACTIVE);
        long totalLandlords = landlordRepository.countByStatus(Status.ACTIVE);
        long totalRealEstates = realEstateRepository.count();
        long totalRents = rentRepository.count();
        long totalPayments = paymentRepository.count();
        long rentedRealEstates = rentRepository.countDistinctActiveRealEstates();
        long vacantRealEstates = rentRepository.countVacantRealEstates();

        return DashboardStatsResponse.builder()
                .totalUsers((int) totalUsers)
                .totalTenants((int) totalTenants)
                .totalLandlords((int) totalLandlords)
                .totalRealEstates((int) totalRealEstates)
                .totalRents((int) totalRents)
                .totalPayments((int) totalPayments)
                .rentedRealEstates((int) rentedRealEstates)
                .vacantRealEstates((int) vacantRealEstates)
                .build();
    }
}
