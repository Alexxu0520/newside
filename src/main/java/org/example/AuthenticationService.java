package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationService {

    private static final String SECRET_KEY = "supersecretkey";  // Secret used for signing the JWT
    private static final long EXPIRATION_TIME = 86400000;       // 1 day in milliseconds (adjust as needed)

    // Simulated user database
    private static Map<String, String> usersDatabase = new HashMap<>();

    static {
        // Username -> Password
        usersDatabase.put("admin", "admin123");
        usersDatabase.put("user", "password");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get username and password
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate the user
        if (authenticate(username, password)) {
            System.out.println("Login successful!");

            // Generate JWT token for the authenticated user
            String token = generateJWT(username);
            System.out.println("Your token: " + token);
        } else {
            System.out.println("Invalid credentials!");
        }

        scanner.close();
    }

    // Method to authenticate the user
    public static boolean authenticate(String username, String password) {
        return usersDatabase.containsKey(username) && usersDatabase.get(username).equals(password);
    }

    // Method to generate a JWT
    public static String generateJWT(String username) {
        // Set the algorithm to sign the token (HMAC SHA256)
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        // Build the token
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(algorithm);
    }
}
