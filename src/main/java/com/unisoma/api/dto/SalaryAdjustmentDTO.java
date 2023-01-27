package com.unisoma.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class SalaryAdjustmentDTO {
    @NotNull
    @Size(max = 11, min = 11)
    private String cpf;

    @NotNull
    private Double salary;

    @NotNull
    private Double readjustment;

    @NotNull
    private Double percentual;
}
