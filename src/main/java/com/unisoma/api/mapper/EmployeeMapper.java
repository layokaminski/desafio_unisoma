package com.unisoma.api.mapper;

import com.unisoma.api.dto.EmployeeDTO;
import com.unisoma.api.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setCpf(dto.getCpf());
        employee.setAddress(dto.getAddress());
        employee.setPhone(dto.getPhone());
        employee.setBirthday(dto.getBirthday());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public EmployeeDTO toDto(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setCpf(employee.getCpf());
        dto.setAddress(employee.getAddress());
        dto.setPhone(employee.getPhone());
        dto.setBirthday(employee.getBirthday());
        dto.setSalary(employee.getSalary());
        return dto;
    }

    public List<EmployeeDTO> toDto(List<Employee> listStock) {
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }
}
