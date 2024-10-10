package org.example;

public class TextInput {

    private String text;
    private String type = "text";

    public TextInput(String text) {
        this.text = text;
    }

    // Getters and setters
    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public void setText(String text) {
        this.text = text;
    }
}
