package com.unisoma.api.service;

import com.unisoma.api.dto.EmployeeDTO;
import com.unisoma.api.exceptions.BusinessException;
import com.unisoma.api.exceptions.NotFoundException;
import com.unisoma.api.mapper.EmployeeMapper;
import com.unisoma.api.model.Employee;
import com.unisoma.api.repository.EmployeeRepository;
import com.unisoma.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public EmployeeDTO save(EmployeeDTO dto) {
        Optional<Employee> optionalEmployee = employeeRepository.findByCpf(dto.getCpf());
        if(optionalEmployee.isPresent()){
            throw new BusinessException(MessageUtils.EMPLOYEE_ALREADY_EXISTS);
        }

        Employee employeeSave = mapper.toEntity(dto);
        Employee employee = employeeRepository.save(employeeSave);

        return mapper.toDto(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return mapper.toDto(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return employeeRepository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO dto) {
        Employee employee = mapper.toEntity(dto);
        employeeRepository.save(employee);
        return mapper.toDto(employee);
    }

    @Override
    public void deleteById(Long id) {
        EmployeeDTO dto = findById(id);
        employeeRepository.deleteById(dto.getId());
    }

}