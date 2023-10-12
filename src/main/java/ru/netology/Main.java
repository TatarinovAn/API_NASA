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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.List;

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

        try {
            BufferedImage image;
            URL url = new URL(nasaURL.getUrl());

            image = ImageIO.read(url);

            if (image != null) {
                ImageIO.write(image, "jpg", new File(words[words.length - 1]));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


    }
}