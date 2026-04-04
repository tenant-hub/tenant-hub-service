package com.obntech.tenanthub.service;

import com.obntech.tenanthub.dto.request.LandlordCreateRequest;
import com.obntech.tenanthub.dto.request.LandlordUpdateRequest;
import com.obntech.tenanthub.dto.response.LandlordResponse;
import com.obntech.tenanthub.entity.LandlordEntity;
import com.obntech.tenanthub.entity.UserEntity;
import com.obntech.tenanthub.enums.Status;
import com.obntech.tenanthub.exception.BusinessException;
import com.obntech.tenanthub.exception.ErrorCode;
import com.obntech.tenanthub.mapper.LandlordMapper;
import com.obntech.tenanthub.repository.LandlordRepository;
import com.obntech.tenanthub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class LandlordService {

    private final LandlordRepository landlordRepository;
    private final UserRepository userRepository;
    private final LandlordMapper landlordMapper;

    @Transactional(readOnly = true)
    public LandlordResponse getById(Long id) {
        log.info("Landlord getiriliyor. id: {}", id);
        return landlordMapper.toResponse(findById(id));
    }

    @Transactional(readOnly = true)
    public Page<LandlordResponse> getAll(Pageable pageable) {
        log.info("Landlord'lar listeleniyor. (ACTIVE)");
        return landlordRepository.findAllByStatus(Status.ACTIVE, pageable).map(landlordMapper::toResponse);
    }

    @Transactional
    public LandlordResponse create(LandlordCreateRequest request, String createdIp) {
        log.info("Landlord oluşturuluyor. usersId: {}", request.getUsersId());

        UserEntity user = findUserById(request.getUsersId());

        LandlordEntity entity = new LandlordEntity();
        entity.setUser(user);
        entity.setCreatedBy("SYSTEM");
        entity.setCreatedDate(LocalDateTime.now());
        entity.setCreatedIp(createdIp);

        LandlordEntity saved = landlordRepository.save(entity);
        log.info("Landlord oluşturuldu. id: {}", saved.getId());
        return landlordMapper.toResponse(saved);
    }

    @Transactional
    public LandlordResponse update(Long id, LandlordUpdateRequest request, String updatedIp) {
        log.info("Landlord güncelleniyor. id: {}", id);
        LandlordEntity entity = findById(id);

        UserEntity user = findUserById(request.getUsersId());
        entity.setUser(user);
        entity.setUpdatedBy("SYSTEM");
        entity.setUpdatedDate(LocalDateTime.now());
        entity.setUpdatedIp(updatedIp);

        log.info("Landlord güncellendi. id: {}", id);
        return landlordMapper.toResponse(landlordRepository.save(entity));
    }

    @Transactional
    public void delete(Long id, String updatedIp) {
        log.info("Landlord siliniyor (soft delete). id: {}", id);
        LandlordEntity entity = findById(id);
        entity.setStatus(Status.INACTIVE);
        entity.setUpdatedBy("SYSTEM");
        entity.setUpdatedDate(LocalDateTime.now());
        entity.setUpdatedIp(updatedIp);
        landlordRepository.save(entity);
        log.info("Landlord silindi (soft delete). id: {}", id);
    }

    public LandlordEntity findById(Long id) {
        return landlordRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Landlord bulunamadı. id: " + id, ErrorCode.ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    private UserEntity findUserById(Long usersId) {
        return userRepository.findById(usersId)
                .orElseThrow(() -> new BusinessException("Kullanıcı bulunamadı. id: " + usersId, ErrorCode.ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND));
    }
}
