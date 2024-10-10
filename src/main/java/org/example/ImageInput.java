package org.example;

public class ImageInput {

    private ImageURL image_url;
    private String type = "image_url";

    public ImageInput(String url) {
        this.image_url = new ImageURL(url);
    }

    // Getters and setters
    public ImageURL getImageUrl() {
        return image_url;
    }

    public String getType() {
        return type;
    }

    public void setImageUrl(ImageURL image_url) {
        this.image_url = image_url;
    }

    public static class ImageURL {
        private String url;

        public ImageURL(String url) {
            this.url = url;
        }

        // Getters and setters
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
