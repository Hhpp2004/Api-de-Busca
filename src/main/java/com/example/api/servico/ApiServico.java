package com.example.api.servico;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.api.dto.EnderecoDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiServico {

    public EnderecoDto getEndereco(String cep) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), EnderecoDto.class);
        } else {
            throw new RuntimeException("Failed to fetch data: " + response.statusCode());
        }
    }
}
