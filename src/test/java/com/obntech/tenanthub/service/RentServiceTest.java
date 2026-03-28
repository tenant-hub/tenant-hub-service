package com.obntech.tenanthub.service;

import com.obntech.tenanthub.dto.request.RentCreateRequest;
import com.obntech.tenanthub.dto.request.RentUpdateRequest;
import com.obntech.tenanthub.dto.response.RentResponse;
import com.obntech.tenanthub.entity.RealEstateEntity;
import com.obntech.tenanthub.entity.RentEntity;
import com.obntech.tenanthub.mapper.RentMapper;
import com.obntech.tenanthub.repository.RentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RentServiceTest {

    @Mock
    private RentRepository rentRepository;

    @Mock
    private RealEstateService realEstateService;

    @Mock
    private RentMapper rentMapper;

    @InjectMocks
    private RentService rentService;

    private RealEstateEntity realEstate;

    @BeforeEach
    void setUp() {
        realEstate = new RealEstateEntity();
        realEstate.setId(1L);
        realEstate.setName("Test Mülk");
    }

    @Test
    void create_withIncreaseRate_shouldPersistIncreaseRate() {
        LocalDateTime paymentDueDate = LocalDateTime.now().plusMonths(1);
        RentCreateRequest request = RentCreateRequest.builder()
                .realEstateId(1L)
                .rentDate(LocalDateTime.now())
                .rentAmount(new BigDecimal("5000.00"))
                .currency("TRY")
                .increaseRate(new BigDecimal("12.50"))
                .paymentDueDate(paymentDueDate)
                .build();

        RentEntity savedEntity = new RentEntity();
        savedEntity.setId(1L);
        savedEntity.setIncreaseRate(new BigDecimal("12.50"));
        savedEntity.setPaymentDueDate(paymentDueDate);

        RentResponse expectedResponse = RentResponse.builder()
                .id(1L)
                .increaseRate(new BigDecimal("12.50"))
                .paymentDueDate(paymentDueDate)
                .build();

        when(realEstateService.findById(1L)).thenReturn(realEstate);
        when(rentRepository.save(any(RentEntity.class))).thenReturn(savedEntity);
        when(rentMapper.toResponse(savedEntity)).thenReturn(expectedResponse);

        RentResponse result = rentService.create(request, "127.0.0.1");

        assertThat(result.getIncreaseRate()).isEqualByComparingTo(new BigDecimal("12.50"));
        assertThat(result.getPaymentDueDate()).isEqualTo(paymentDueDate);
        verify(rentRepository).save(argThat(entity ->
                new BigDecimal("12.50").compareTo(entity.getIncreaseRate()) == 0
                        && paymentDueDate.equals(entity.getPaymentDueDate())
        ));
    }

    @Test
    void create_withoutIncreaseRate_shouldPersistNullIncreaseRate() {
        LocalDateTime paymentDueDate = LocalDateTime.now().plusMonths(1);
        RentCreateRequest request = RentCreateRequest.builder()
                .realEstateId(1L)
                .rentDate(LocalDateTime.now())
                .rentAmount(new BigDecimal("5000.00"))
                .currency("TRY")
                .increaseRate(null)
                .paymentDueDate(paymentDueDate)
                .build();

        RentEntity savedEntity = new RentEntity();
        savedEntity.setId(2L);
        savedEntity.setIncreaseRate(null);
        savedEntity.setPaymentDueDate(paymentDueDate);

        RentResponse expectedResponse = RentResponse.builder()
                .id(2L)
                .increaseRate(null)
                .paymentDueDate(paymentDueDate)
                .build();

        when(realEstateService.findById(1L)).thenReturn(realEstate);
        when(rentRepository.save(any(RentEntity.class))).thenReturn(savedEntity);
        when(rentMapper.toResponse(savedEntity)).thenReturn(expectedResponse);

        RentResponse result = rentService.create(request, "127.0.0.1");

        assertThat(result.getIncreaseRate()).isNull();
        assertThat(result.getPaymentDueDate()).isEqualTo(paymentDueDate);
        verify(rentRepository).save(argThat(entity ->
                entity.getIncreaseRate() == null
                        && paymentDueDate.equals(entity.getPaymentDueDate())
        ));
    }

    @Test
    void update_withIncreaseRate_shouldUpdateIncreaseRate() {
        LocalDateTime paymentDueDate = LocalDateTime.now().plusMonths(2);
        RentUpdateRequest request = RentUpdateRequest.builder()
                .realEstateId(1L)
                .rentDate(LocalDateTime.now())
                .rentAmount(new BigDecimal("6000.00"))
                .currency("TRY")
                .increaseRate(new BigDecimal("25.00"))
                .paymentDueDate(paymentDueDate)
                .build();

        RentEntity existingEntity = new RentEntity();
        existingEntity.setId(1L);
        existingEntity.setIncreaseRate(new BigDecimal("10.00"));

        RentEntity updatedEntity = new RentEntity();
        updatedEntity.setId(1L);
        updatedEntity.setIncreaseRate(new BigDecimal("25.00"));
        updatedEntity.setPaymentDueDate(paymentDueDate);

        RentResponse expectedResponse = RentResponse.builder()
                .id(1L)
                .increaseRate(new BigDecimal("25.00"))
                .paymentDueDate(paymentDueDate)
                .build();

        when(rentRepository.findById(1L)).thenReturn(java.util.Optional.of(existingEntity));
        when(realEstateService.findById(1L)).thenReturn(realEstate);
        when(rentRepository.save(any(RentEntity.class))).thenReturn(updatedEntity);
        when(rentMapper.toResponse(updatedEntity)).thenReturn(expectedResponse);

        RentResponse result = rentService.update(1L, request, "127.0.0.1");

        assertThat(result.getIncreaseRate()).isEqualByComparingTo(new BigDecimal("25.00"));
        assertThat(result.getPaymentDueDate()).isEqualTo(paymentDueDate);
        verify(rentRepository).save(argThat(entity ->
                new BigDecimal("25.00").compareTo(entity.getIncreaseRate()) == 0
                        && paymentDueDate.equals(entity.getPaymentDueDate())
        ));
    }
}
