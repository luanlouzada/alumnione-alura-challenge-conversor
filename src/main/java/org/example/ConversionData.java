package org.example;

import java.math.BigDecimal;

public class ConversionData {
    private String baseCurrency;
    private String destCurrency;
    private BigDecimal amount;
    private BigDecimal result;

    public ConversionData(String base, String dest, BigDecimal amount){
        this.baseCurrency = base;
        this.destCurrency = dest;
        this.amount = amount;
    }

    public String getBaseCurrency(){
        return this.baseCurrency;
    }

    public String getDestCurrency(){
        return this.destCurrency;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public BigDecimal getResult(){
        return this.result;
    }

    private void setResult(BigDecimal result){
        this.result = result;
    }

    public BigDecimal getCalculatedResult(BigDecimal value){
        this.setResult(this.amount.multiply(value));
        return this.getResult();
    }
}