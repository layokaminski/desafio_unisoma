package com.unisoma.api.dto;

import lombok.Getter;
import org.springframework.data.util.Pair;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
public enum SalaryAdjustment {
    FIRST(Pair.of(0.0, 400.00), 15.0),
    SECOND(Pair.of(400.01, 800.00), 12.0),
    THIRD(Pair.of(800.01, 1200.00), 10.0),
    FOURTH(Pair.of(1200.01, 2000.00), 7.0),
    FIFTH(Pair.of(2000.01, Double.MAX_VALUE), 4.0);

    private final Pair<Double, Double> range;
    private final Double percentual;

    SalaryAdjustment(final Pair<Double, Double> range, final Double percentual) {
        this.range = range;
        this.percentual = percentual;
    }

    public static Optional<SalaryAdjustment> getPercentualBySalary(final Double salary) {
        return Stream.of(SalaryAdjustment.values()).filter(salaryAdjustment ->
                salary >= salaryAdjustment.range.getFirst() && salary <= salaryAdjustment.range.getSecond()
        ).findFirst();
    }
}