package com.unisoma.api.controller;

import com.unisoma.api.dto.TaxesDTO;
import com.unisoma.api.service.TaxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/tax")
public class TaxesController {

    @Autowired
    private TaxesService taxesService;

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<TaxesDTO>> findByCpf(@PathVariable String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(taxesService.findByCpf(cpf));
    }
}
