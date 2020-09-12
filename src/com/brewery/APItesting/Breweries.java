package com.brewery.APItesting;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.brewery.models.Brewery;

import com.fravega.utilities.Reader;
import com.google.gson.Gson;

public class Breweries extends AbstractTestNGSpringContextTests {
	
    private Gson gson = new Gson();
    private String apiUrl = "https://api.openbrewerydb.org/breweries/";
    
    HttpClient http;

    @Test
    public void searchForBreweries() throws IOException {
        
        HttpResponse getBrewery = http.get(apiUrl + "autocomplete?query=lagunitas");
        Brewery getParsedBreweries = gson.fromJson(getContent(getBrewery), Brewery.class);
    }

    private String getContent(HttpResponse response) throws IOException {
        return IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
    }

}