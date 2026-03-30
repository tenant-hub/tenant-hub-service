package com.obntech.tenanthub.repository;

import com.obntech.tenanthub.entity.RealEstateEntity;
import com.obntech.tenanthub.entity.RentEntity;
import com.obntech.tenanthub.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRepository extends JpaRepository<RentEntity, Long> {

    Page<RentEntity> findAllByStatus(Status status, Pageable pageable);

    List<RentEntity> findAllByRealEstateId(Long realEstateId);

    Page<RentEntity> findAllByRealEstateId(Long realEstateId, Pageable pageable);

    @Query("SELECT COUNT(DISTINCT r.realEstate.id) FROM RentEntity r WHERE r.status = 'ACTIVE'")
    long countDistinctActiveRealEstates();

    @Query("SELECT COUNT(DISTINCT re.id) FROM RealEstateEntity re WHERE re.status = 'ACTIVE' AND NOT EXISTS (SELECT 1 FROM RentEntity r WHERE r.realEstate.id = re.id AND r.status = 'ACTIVE')")
    long countVacantRealEstates();
}
