package com.unisoma.api.service;

import com.unisoma.api.dto.SalaryAdjustment;
import com.unisoma.api.dto.SalaryAdjustmentDTO;
import com.unisoma.api.exceptions.NotFoundException;
import com.unisoma.api.model.Employee;
import com.unisoma.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryAdjustmentServiceImpl implements  SalaryAdjustmentService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private SalaryAdjustment salaryAdjustment;

    @Override
    public Optional<SalaryAdjustmentDTO> findByCpf(String cpf) {
        SalaryAdjustmentDTO dto = new SalaryAdjustmentDTO();
        Employee employee = employeeRepository.findByCpf(cpf).orElseThrow(NotFoundException::new);

        Optional<SalaryAdjustment> adjustment = salaryAdjustment.getPercentualBySalary(employee.getSalary());

        if (!adjustment.isPresent()) {
            throw new IllegalArgumentException();
        };

        Double percentual = adjustment.get().getPercentual();
        dto.setReadjustment((double) Math.round((percentual / 100) * employee.getSalary()));
        Double newSalary = employee.getSalary() + dto.getReadjustment();


        dto.setCpf(employee.getCpf());
        dto.setSalary(newSalary);
        dto.setPercentual(percentual);

        employee.setSalary(newSalary);

        employeeRepository.save(employee);

        return Optional.of(dto);
    }
}
