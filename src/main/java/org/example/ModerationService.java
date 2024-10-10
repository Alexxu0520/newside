package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ModerationService {

    private static final String API_URL = "https://api.openai.com/v1/moderations";
    private final String apiKey;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final ModerationRepository moderationRepository;

    public ModerationService(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.moderationRepository = new ModerationRepository();
    }

    // Method to moderate content and save results
    public ModerationNewResponse moderate(ModerationNewParams params, String userId) throws IOException, InterruptedException, SQLException {
        // Call the OpenAI Moderation API
        ModerationNewResponse response = callModerationAPI(params);

        // Save moderation results to PostgreSQL
        moderationRepository.saveModerationResult(userId, response);

        return response;
    }

    // Internal method to handle the API call
    private ModerationNewResponse callModerationAPI(ModerationNewParams params) throws IOException, InterruptedException {
        String requestBody = objectMapper.writeValueAsString(params);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ModerationNewResponse.class);
        } else {
            throw new IOException("Error during API call: " + response.body());
        }
    }
}
