package com.obntech.tenanthub.controller;

import com.obntech.tenanthub.dto.request.TenantCreateRequest;
import com.obntech.tenanthub.dto.request.TenantUpdateRequest;
import com.obntech.tenanthub.dto.response.TenantResponse;
import com.obntech.tenanthub.service.TenantService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tenants")
@RequiredArgsConstructor
@Slf4j
public class TenantController {

    private final TenantService tenantService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('TENANT_READ')")
    public ResponseEntity<TenantResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tenantService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('TENANT_READ')")
    public ResponseEntity<Page<TenantResponse>> getAll(
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(tenantService.getAll(pageable));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('TENANT_CREATE')")
    public ResponseEntity<TenantResponse> create(
            @Valid @RequestBody TenantCreateRequest request,
            HttpServletRequest httpRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tenantService.create(request, httpRequest.getRemoteAddr()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('TENANT_UPDATE')")
    public ResponseEntity<TenantResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody TenantUpdateRequest request,
            HttpServletRequest httpRequest) {
        return ResponseEntity.ok(tenantService.update(id, request, httpRequest.getRemoteAddr()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('TENANT_DELETE')")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            HttpServletRequest httpRequest) {
        tenantService.delete(id, httpRequest.getRemoteAddr());
        return ResponseEntity.noContent().build();
    }
}
