package org.example;

import java.math.BigDecimal;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) {
        IO io = new IO();
        String apiKey = "693656a361295694607dad21"; // Substitua pela sua chave de API

        String baseCurrency = io.getBaseCurrency();
        String destCurrency = io.getDestCurrency();
        BigDecimal amount = io.getAmount();

        ConversionData data = new ConversionData(baseCurrency, destCurrency, amount);

        try {
            API api = new API(apiKey, baseCurrency);
            String response = api.sendRequest();


            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            if (conversionRates.has(destCurrency)) {
                BigDecimal conversionRate = conversionRates.get(destCurrency).getAsBigDecimal();
                BigDecimal result = data.getCalculatedResult(conversionRate);
                io.printResult(data);
            } else {
                System.out.println("Conversion rate not found for the specified currency.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
