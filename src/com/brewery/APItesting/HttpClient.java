package com.brewery.APItesting;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {

	private org.apache.http.client.HttpClient client = HttpClients.custom().build();
	
	private Header JSON[] = {
            new BasicHeader("Content-type", "application/json"),
            new BasicHeader("Accept", "application/json")
    };

    public HttpResponse get(String url) throws IOException {
    	HttpGet getRequest = new HttpGet(url);
        getRequest.setHeaders(JSON);
        return client.execute(getRequest);
    }

}