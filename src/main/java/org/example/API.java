package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class API {
    private final String basePath;
    private final String apiEndpoint;
    private String url;
    private final String apiKey;
    private String baseCurrency;

    public API(String apiKey, String baseCurrency) {
        this.apiKey = apiKey;
        this.baseCurrency = baseCurrency;
        this.basePath = "https://v6.exchangerate-api.com/v6/";
        this.apiEndpoint = "/latest/";
        this.url = this.basePath + this.apiKey + this.apiEndpoint + this.baseCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
        this.url = this.basePath + this.apiKey + this.apiEndpoint + this.baseCurrency;
    }

    public String getUrl() {
        return url;
    }

    public String sendRequest() throws Exception {
        URI uri = new URI(this.url);
        HttpURLConnection request = (HttpURLConnection) uri.toURL().openConnection();
        request.setRequestMethod("GET");
        request.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }
}

