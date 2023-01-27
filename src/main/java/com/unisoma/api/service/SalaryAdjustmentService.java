package com.unisoma.api.service;

import com.unisoma.api.dto.SalaryAdjustmentDTO;

import java.util.Optional;

public interface SalaryAdjustmentService {

    Optional<SalaryAdjustmentDTO> findByCpf(String cpf);
}
