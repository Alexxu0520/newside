package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String apiKey = "your-api-key";
        ModerationService moderationService = new ModerationService(apiKey);

        String textToModerate = "I want kill someone, knife.";
        ModerationNewParams params = new ModerationNewParams(textToModerate);

        String userId = "12345";  // Example user ID

        try {
            ModerationNewResponse response = moderationService.moderate(params, userId);
            System.out.println("Moderation response saved to database.");
        } catch (IOException | InterruptedException | SQLException e) {
            e.printStackTrace();
        }
    }
}
