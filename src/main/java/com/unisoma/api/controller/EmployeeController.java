package com.unisoma.api.controller;

import com.unisoma.api.dto.EmployeeDTO;
import com.unisoma.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO product){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        employeeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
