package org.example;
import java.math.BigDecimal;
import java.util.Scanner;

public class IO {
    private final Scanner scanner;
    private String out;

    public IO() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public String getOut() {
        return this.out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getBaseCurrency() {
        System.out.print("Enter the base currency code (e.g., USD, EUR): ");
        return scanner.nextLine().toUpperCase();
    }

    public String getDestCurrency() {
        System.out.print("Enter the destination currency code (e.g., USD, EUR): ");
        return scanner.nextLine().toUpperCase();
    }

    public BigDecimal getAmount() {
        System.out.print("Enter the amount to convert: ");
        return scanner.nextBigDecimal();
    }

    public void printResult(ConversionData data) {
        System.out.printf("%.2f %s is equal to %.2f %s%n",
                data.getAmount(), data.getBaseCurrency(),
                data.getResult(), data.getDestCurrency());
    }
}
