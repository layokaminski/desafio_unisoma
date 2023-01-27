package com.unisoma.api.service;

import com.unisoma.api.dto.EmployeeDTO;
import com.unisoma.api.exceptions.BusinessException;
import com.unisoma.api.mapper.EmployeeMapper;
import com.unisoma.api.model.Employee;
import com.unisoma.api.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Mock
    private EmployeeRepository repository;

    @Mock
    private EmployeeMapper mapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerSuccess() {

        EmployeeDTO employeeDTO = new EmployeeDTO(
                1L,
                "Test",
                "12345678910",
                LocalDate.of(1989, 01, 13),
                "Rua Test",
                "1199999999",
                3500.0
        );

        Employee employee = new Employee(
                1L,
                "Test",
                "12345678910",
                LocalDate.of(1989, 01, 13),
                "Rua Test",
                "1199999999",
                3500.0
        );

        employeeService.save(employeeDTO);
        when(repository.findByCpf(eq(employeeDTO.getCpf()))).thenReturn(Optional.empty());
        when(mapper.toEntity(any(EmployeeDTO.class))).thenReturn(employee);
        when(repository.save(any(Employee.class))).thenReturn(employee);

        assertEquals(employeeDTO.getId(), employee.getId());
        assertEquals(employeeDTO.getName(), employee.getName());
        assertEquals(employeeDTO.getName(), employee.getName());
        assertEquals(employeeDTO.getCpf(), employee.getCpf());
        assertEquals(employeeDTO.getAddress(), employee.getAddress());
        assertEquals(employeeDTO.getPhone(), employee.getPhone());
        assertEquals(employeeDTO.getSalary(), employee.getSalary());
    }

    @Test
    public void registerEmployeeAlready() {

        EmployeeDTO employeeDTO = new EmployeeDTO(
                1L,
                "Test",
                "12345678910",
                LocalDate.of(1989, 01, 13),
                "Rua Test",
                "1199999999",
                3500.0
        );

        Employee employee = new Employee(
                1L,
                "Test",
                "12345678910",
                LocalDate.of(1989, 01, 13),
                "Rua Test",
                "1199999999",
                3500.0
        );

        when(repository.findByCpf(eq(employeeDTO.getCpf()))).thenReturn(Optional.of(employee));

        assertThrows(BusinessException.class, () -> {
                employeeService.save(employeeDTO);
        });
    }
}
