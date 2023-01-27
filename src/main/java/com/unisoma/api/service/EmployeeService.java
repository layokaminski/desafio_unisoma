package com.unisoma.api.service;

import com.unisoma.api.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO employee);

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(Long id);

    EmployeeDTO update(EmployeeDTO product);

    void deleteById(Long id);

}
