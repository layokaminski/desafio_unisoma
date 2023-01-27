package com.unisoma.api.controller;

import com.unisoma.api.dto.SalaryAdjustmentDTO;
import com.unisoma.api.service.SalaryAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/adjustment")
public class SalaryAdjustmentController {

    @Autowired
    private SalaryAdjustmentService salaryAdjustmentService;

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<SalaryAdjustmentDTO>> findByCpf(@PathVariable String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(salaryAdjustmentService.findByCpf(cpf));
    }
}
