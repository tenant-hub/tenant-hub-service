package com.obntech.tenanthub.repository;

import com.obntech.tenanthub.entity.TenantEntity;
import com.obntech.tenanthub.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<TenantEntity, Long> {

    Page<TenantEntity> findAllByStatus(Status status, Pageable pageable);
}
