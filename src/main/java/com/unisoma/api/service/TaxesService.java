package com.unisoma.api.service;

import com.unisoma.api.dto.TaxesDTO;

import java.util.Optional;

public interface TaxesService {

    Optional<TaxesDTO> findByCpf(String cpf);
}
