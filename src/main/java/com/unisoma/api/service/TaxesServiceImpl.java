package com.unisoma.api.service;

import com.unisoma.api.dto.TaxImplement;
import com.unisoma.api.dto.TaxesDTO;
import com.unisoma.api.exceptions.NotFoundException;
import com.unisoma.api.model.Employee;
import com.unisoma.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaxesServiceImpl implements  TaxesService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private TaxImplement taxImplement;

    @Override
    public Optional<TaxesDTO> findByCpf(String cpf) {
        TaxesDTO dto = new TaxesDTO();
        Employee employee = employeeRepository.findByCpf(cpf).orElseThrow(NotFoundException::new);

        Double tax = TaxImplement.calculateTaxes(employee.getSalary());

        if (tax.isNaN()) {
            throw new IllegalArgumentException();
        };

        dto.setCpf(employee.getCpf());
        dto.setTax(tax);

        return Optional.of(dto);
    }
}
