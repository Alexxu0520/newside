package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModerationRepository {

    public void saveModerationResult(String userId, ModerationNewResponse response) throws SQLException, JsonProcessingException {
        String query = "INSERT INTO moderation_results (user_id, result) VALUES (?, ?::jsonb)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Convert ModerationNewResponse object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResult = objectMapper.writeValueAsString(response);

            stmt.setString(1, userId);
            stmt.setString(2, jsonResult);

            stmt.executeUpdate();
        }
    }
}
