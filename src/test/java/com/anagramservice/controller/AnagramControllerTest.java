package com.anagramservice.controller;

import com.anagramservice.model.AnagramRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramControllerTest {

    private static final int PORT = 8080;
    private static WireMockServer wireMockServer;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final RestTemplate restTemplate = new RestTemplate();

    @BeforeAll
    public static void setup() {
        wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        WireMock.configureFor("localhost", PORT);
    }

    @AfterAll
    public static void tearDown() {
        wireMockServer.stop();
    }

    @Test
    public void testCheckAnagrams() throws Exception {
        String firstWord = "listen";
        String secondWord = "silent";

        AnagramRequest request = new AnagramRequest(firstWord, secondWord);
        String requestBody = objectMapper.writeValueAsString(request);

        wireMockServer.stubFor(post(urlEqualTo("/anagrams"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE)
                        .withBody(firstWord + " and " + secondWord + " are anagrams")));

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + PORT + "/anagrams", requestBody, String.class);

        String expectedResponseBody = firstWord + " and " + secondWord + " are anagrams";
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponseBody, response.getBody());
    }
}
