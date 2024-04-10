package C22737179;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.Visual;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import processing.*;
import processing.core.PGraphics; // Import the PGraphics class

public class AaronVisuals extends Visual {

    // Declare variables and objects
    DrawGrid grid;
    Fade fade;
    float angle = 0.5f;
    float offset = 0;
    float scalar = 1;
    float speed = 0.02f;
    int numEllipses = 5;
    boolean clearScreen = true;
    int shapeColor;
    float cloudX, cloudY = -50;
    float x;
    float y;
    float z;
    Drop[] d;
    int cloudNumber = 40;
    Cloud[] clouds;
    float cloudSpeed = 1.5f;
    String[] words = {"Clouds", "World", "Fluffy", "Little", "Cloud", "Everwhere", "Floating", "And", "skies", "always", "little", "fluffy", "clouds", "They", "were", "long", "clear"};
    int numWords = words.length;
    float[] xPositions, yPositions;
    float[] xSpeeds, ySpeeds;
    float[] lerpedBuffer;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    int inside = color(204, 102, 0);
    int middle = color(204, 153, 0);
    int outside = color(153, 51, 0);

    // Constructor
    public AaronVisuals() {
        // Initialize variables and objects
        clouds = new Cloud[cloudNumber];
        grid = new DrawGrid(this);

        // Initialize clouds
        for (int i = 0; i < cloudNumber; i++) {
            float a = random(20, 80);
            float x;

            // Randomize between left and right sides of the screen
            if (random(1) > 0.5) {
                x = random(width / 2) - a; // Random x-coordinate on the left half of the screen
            } else {
                x = random(width / 2, width - a); // Random x-coordinate on the right half of the screen
            }

            float y = random(height); // Random y-coordinate
            float radius = random(40, 100); // Random radius for cloud size   
            float b = random(10, 60);
            clouds[i] = new Cloud(x, y, radius, a, b);
        }

        // Initialize arrays for word positions and speeds
        xPositions = new float[numWords];
        yPositions = new float[numWords];
        xSpeeds = new float[numWords];
        ySpeeds = new float[numWords];

        // Initialize word positions and speeds
        for (int i = 0; i < numWords; i++) {
            xPositions[i] = random(0, width);
            yPositions[i] = random(0, height);
            xSpeeds[i] = random(-5, 5);
            ySpeeds[i] = random(-5, 5);
        }
    }

    // Method to simulate rain
    public void rain(CallSet e) {
        translate(0, e.height);
        d = new Drop[100];
        for (int i = 0; i < d.length; i++) {
            // Start each drop at a random position along the x-axis
            d[i] = new Drop(e.random(e.width), e.random(-e.height, 0), e.random(5), e);
        }

        for (int i = 0; i < d.length; i++) {
            d[i].show();
            d[i].update();
        }
    }

    // Method to show a line
    public void show(CallSet e) {
        float t = map(z, 0, 5, 10, 2);
        e.strokeWeight(t);
        line(x, y, x, y + t * 2);
    }

    // Method to update the line position
    public void update(CallSet e) {
        y = y + 4;

        if (y > e.height + 10) {
            y = -10;
            x = e.random(e.width); // Start the drop from a random x-position again
        }
    }

    // Method to draw a cloud shape
    void cloudObject(float a, float b, float c, float d) {
        noStroke();
        fill(200);

        ellipse(x - 20, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x + 20, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x, y - 10, c, d); // Adjusting the y-coordinate to slightly raise the cloud

        ellipse(x - 150, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x + 150, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x, y - 130, c, d); // Adjusting the y-coordinate to slightly raise the cloud
    }

    // Method to draw all visual elements
    public void draw(CallSet e) {
        this.g = e.getGraphics(); // Initialize the "g" variable

        colorMode(RGB);
        background(0);
        shapeColor = color(random(255), random(255), random(255));
        stroke(255);
        fill(200); // Set fill color to light gray

        // Draw rain
        pushMatrix();
        rain(e);
        popMatrix();

        // Draw words
        pushMatrix();
        for (int i = 0; i < numWords; i++) {
            textSize(100);
            fill(255);
            text(words[i], xPositions[i], yPositions[i]);

            xPositions[i] += xSpeeds[i];
            yPositions[i] += ySpeeds[i];

            if (xPositions[i] > e.width || xPositions[i] < 0) {
                xSpeeds[i] *= -1;
            }
            if (yPositions[i] > e.height || yPositions[i] < 0) {
                ySpeeds[i] *= -1;
            }
        }
        popMatrix();

        // Draw clouds
        pushMatrix();
        translate(e.width / 2, e.height / 2);
        for (int i = 0; i < cloudNumber; i++) {
            // Update the x-coordinate of each cloud
            clouds[i].move(cloudSpeed);
            // Draw the cloud at its updated position
            clouds[i].display(e);
        }
        popMatrix();

        pushMatrix();
        translate(e.width / 5, e.height / 3);
        for (int i = 0; i < cloudNumber; i++) {
            // Update the x-coordinate of each cloud
            clouds[i].move(cloudSpeed);
            // Draw the cloud at its updated position
            clouds[i].display(e);
        }
        popMatrix();
    }

    // Inner class to represent a cloud
    class Cloud {
        float x, y; // Position of the cloud
        float radius; // Size of the cloud
        float a, b; // Shape parameters for the cloud

        Cloud(float x, float y, float radius, float a, float b) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.a = a;
            this.b = b;
        }

        // Method to move the cloud
        void move(float cloudSpeed) {
            x += cloudSpeed; // Move the cloud horizontally
            if (x > width + radius) {
                x = -radius;
                y = random(height);
            }
        }

        // Method to display the cloud
        void display(CallSet e) {
            fill(255);
            ellipse(x - 20, y, a, b);
            ellipse(x + 20, y, a, b);
            ellipse(x, y - 10, a, b);
        }
    }
}
