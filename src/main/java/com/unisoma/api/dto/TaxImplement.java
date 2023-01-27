package com.unisoma.api.dto;

public class TaxImplement {

    public static Double calculateTaxes(final Double salary) {
        double taxToPay = 0.0;

        if(salary > 4500.00) {
            taxToPay = 1000 * 0.08 + 1500 * 0.18;
            taxToPay +=  (salary - 4500.00) * 0.28;
        } else if(salary > 3000.00) {
            taxToPay = 1000 * 0.08;
            taxToPay +=  (salary - 3000.00) * 0.18;
        } else if(salary > 2000.00) {
            taxToPay = (salary - 2000.00) * 0.08;
        }

        return taxToPay;
    }
}
