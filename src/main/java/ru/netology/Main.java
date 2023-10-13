package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static final String REMOTE_SERVICE_URL =
            "https://api.nasa.gov/planetary/apod?api_key=oktlyP6R9tctcNtC6XY7CScDzNBWdamLuYnTPN1x";
    public static ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) throws IOException {
        CloseableHttpClient client =
                HttpClientBuilder.create().setUserAgent("Nasa API").
                        setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(5000).
                                setSocketTimeout(30000).setRedirectsEnabled(false).build()).build();


        HttpGet request = new HttpGet(REMOTE_SERVICE_URL);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = client.execute(request);

        InputStream nasa = response.getEntity().getContent();


        Nasa nasaURL = mapper.readValue(nasa, new TypeReference<>() {
        });
        String[] words = nasaURL.getUrl().split("/");


        try (BufferedInputStream in = new BufferedInputStream(new URL(nasaURL.getUrl()).openStream());
             FileOutputStream fos = new FileOutputStream(words[words.length - 1])) {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = in.read(buffer, 0, buffer.length)) != -1) {
                fos.write(buffer, 0, count);
                fos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}