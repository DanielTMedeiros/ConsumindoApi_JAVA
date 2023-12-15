package br.al.infnet.util;

import br.al.infnet.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import br.al.infnet.model.Advice;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdviceUtil {
    public Advice getById(int id){
        String uri = "https://api.adviceslip.com/advice/"+ id;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(new URI(uri))
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404){
                throw new ResourceNotFoundException(response.body());
            }
            ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
            Advice advice = mapper.readValue(response.body(), Advice.class);
            return advice;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public Advice getRandomAdvice(){
        String uri = "https://api.adviceslip.com/advice";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(new URI(uri))
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404){
                throw new ResourceNotFoundException(response.body());
            }
            ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
            Advice advice = mapper.readValue(response.body(), Advice.class);
            return advice;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
