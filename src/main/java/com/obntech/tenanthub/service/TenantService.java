package com.obntech.tenanthub.service;

import com.obntech.tenanthub.dto.request.TenantCreateRequest;
import com.obntech.tenanthub.dto.request.TenantUpdateRequest;
import com.obntech.tenanthub.dto.response.TenantResponse;
import com.obntech.tenanthub.entity.TenantEntity;
import com.obntech.tenanthub.entity.UserEntity;
import com.obntech.tenanthub.enums.Status;
import com.obntech.tenanthub.exception.BusinessException;
import com.obntech.tenanthub.exception.ErrorCode;
import com.obntech.tenanthub.mapper.TenantMapper;
import com.obntech.tenanthub.repository.TenantRepository;
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
public class TenantService {

    private final TenantRepository tenantRepository;
    private final UserRepository userRepository;
    private final TenantMapper tenantMapper;

    @Transactional(readOnly = true)
    public TenantResponse getById(Long id) {
        log.info("Tenant getiriliyor. id: {}", id);
        return tenantMapper.toResponse(findById(id));
    }

    @Transactional(readOnly = true)
    public Page<TenantResponse> getAll(Pageable pageable) {
        log.info("Tenant'lar listeleniyor. (ACTIVE)");
        return tenantRepository.findAllByStatus(Status.ACTIVE, pageable).map(tenantMapper::toResponse);
    }

    @Transactional
    public TenantResponse create(TenantCreateRequest request, String createdIp) {
        log.info("Tenant oluşturuluyor. usersId: {}", request.getUsersId());

        UserEntity user = findUserById(request.getUsersId());

        TenantEntity entity = new TenantEntity();
        entity.setUser(user);
        entity.setCreatedBy("SYSTEM");
        entity.setCreatedDate(LocalDateTime.now());
        entity.setCreatedIp(createdIp);

        TenantEntity saved = tenantRepository.save(entity);
        log.info("Tenant oluşturuldu. id: {}", saved.getId());
        return tenantMapper.toResponse(saved);
    }

    @Transactional
    public TenantResponse update(Long id, TenantUpdateRequest request, String updatedIp) {
        log.info("Tenant güncelleniyor. id: {}", id);
        TenantEntity entity = findById(id);

        UserEntity user = findUserById(request.getUsersId());
        entity.setUser(user);
        entity.setUpdatedBy("SYSTEM");
        entity.setUpdatedDate(LocalDateTime.now());
        entity.setUpdatedIp(updatedIp);

        log.info("Tenant güncellendi. id: {}", id);
        return tenantMapper.toResponse(tenantRepository.save(entity));
    }

    @Transactional
    public void delete(Long id, String updatedIp) {
        log.info("Tenant siliniyor (soft delete). id: {}", id);
        TenantEntity entity = findById(id);
        entity.setStatus(Status.INACTIVE);
        entity.setUpdatedBy("SYSTEM");
        entity.setUpdatedDate(LocalDateTime.now());
        entity.setUpdatedIp(updatedIp);
        tenantRepository.save(entity);
        log.info("Tenant silindi (soft delete). id: {}", id);
    }

    public TenantEntity findById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Tenant bulunamadı. id: " + id, ErrorCode.ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    private UserEntity findUserById(Long usersId) {
        return userRepository.findById(usersId)
                .orElseThrow(() -> new BusinessException("Kullanıcı bulunamadı. id: " + usersId, ErrorCode.ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND));
    }
}
