package com.obntech.tenanthub.controller;

import com.obntech.tenanthub.dto.request.LandlordCreateRequest;
import com.obntech.tenanthub.dto.request.LandlordUpdateRequest;
import com.obntech.tenanthub.dto.response.LandlordResponse;
import com.obntech.tenanthub.service.LandlordService;
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
@RequestMapping("/api/v1/landlords")
@RequiredArgsConstructor
@Slf4j
public class LandlordController {

    private final LandlordService landlordService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('LANDLORD_READ')")
    public ResponseEntity<LandlordResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(landlordService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('LANDLORD_READ')")
    public ResponseEntity<Page<LandlordResponse>> getAll(
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(landlordService.getAll(pageable));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('LANDLORD_CREATE')")
    public ResponseEntity<LandlordResponse> create(
            @Valid @RequestBody LandlordCreateRequest request,
            HttpServletRequest httpRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(landlordService.create(request, httpRequest.getRemoteAddr()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('LANDLORD_UPDATE')")
    public ResponseEntity<LandlordResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody LandlordUpdateRequest request,
            HttpServletRequest httpRequest) {
        return ResponseEntity.ok(landlordService.update(id, request, httpRequest.getRemoteAddr()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('LANDLORD_DELETE')")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            HttpServletRequest httpRequest) {
        landlordService.delete(id, httpRequest.getRemoteAddr());
        return ResponseEntity.noContent().build();
    }
}
