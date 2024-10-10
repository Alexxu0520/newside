package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTValidator {

    private static final String SECRET_KEY = "supersecretkey";  // Same secret key used for signing

    // Method to verify the token
    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withSubject("admin")   // Optional: If you want to enforce the subject
                    .build();

            // Verify the token
            DecodedJWT decodedJWT = verifier.verify(token);
            System.out.println("Token is valid. User: " + decodedJWT.getSubject());

            return true;
        } catch (JWTVerificationException exception) {
            // Token is invalid
            System.out.println("Invalid token: " + exception.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Example token (In real scenario, you'd get this from the client-side)
        String token = "your-jwt-token-here";

        // Validate the token
        boolean isValid = verifyToken(token);

        if (isValid) {
            System.out.println("Token validation successful.");
        } else {
            System.out.println("Token validation failed.");
        }
    }
}
