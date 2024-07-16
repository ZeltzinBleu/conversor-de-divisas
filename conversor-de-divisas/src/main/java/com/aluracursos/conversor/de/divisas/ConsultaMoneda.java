package com.aluracursos.conversor.de.divisas;

import com.aluracursos.conversor.de.divisas.conversor.Conversor;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Conversor buscaMoneda(String denominacionBase){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/77e6446de1712b2fc05fca01/latest/"+denominacionBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la operacion");
        }

    }
}

