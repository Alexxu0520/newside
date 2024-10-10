package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JWTGenerator {

    // Define constants
    private static final String SECRET_KEY = "supersecretkey";  // Use a strong key and keep it secret
    private static final long EXPIRATION_TIME = 86400000L;      // 1 day in milliseconds (adjust as needed)

    // Method to generate a JWT
    public static String generateToken(String username) {
        // Define the signing algorithm (HMAC SHA-256)
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        // Create the token
        return JWT.create()
                .withSubject(username)  // Add the subject (e.g., username or userId)
                .withIssuedAt(new Date())  // Add the token issue date
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Add expiration
                .withClaim("role", "admin")  // Example custom claim (user role)
                .sign(algorithm);  // Sign the token with the secret key
    }

    public static void main(String[] args) {
        // Example usage
        String token = generateToken("john_doe");  // Generate a token for the user "john_doe"
        System.out.println("Generated JWT Token: " + token);
    }
}
