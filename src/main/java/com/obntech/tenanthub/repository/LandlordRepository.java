package com.obntech.tenanthub.repository;

import com.obntech.tenanthub.entity.LandlordEntity;
import com.obntech.tenanthub.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordRepository extends JpaRepository<LandlordEntity, Long> {

    Page<LandlordEntity> findAllByStatus(Status status, Pageable pageable);
}
