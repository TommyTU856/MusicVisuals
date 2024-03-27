package C22737179;

import ie.tudublin.Visual;
import processing.core.PApplet;

public class AaronVisuals extends Visual {
    DrawGrid grid;
    Fade fade;
    Rain rain; // Declare Rain object
    

    float angle = 0.5f;
    float offset = 0;
    float scalar = 1;
    float speed = 0.02f;

    int numEllipses = 5; // Number of ellipses
    boolean clearScreen = true;
    int shapeColor;

    
    public AaronVisuals() {
        // Initialize any required variables or objects here
        rain = new Rain(this); // Initialize Rain object
    }

    public void draw(CallSet e) {
        this.g = e.getGraphics(); // Initialize the "g" variable
        grid = new DrawGrid(this);
        fade = new Fade(100, 100, 1000, this); // Initialize Fade object with specific values

        colorMode(RGB);
        if (clearScreen) {
            background(0); // Use color() function for background color (black)
            shapeColor = color(random(255), random(255), random(255));
        }

        fade.update();
        fade.display();

        stroke(255);
        fill(200); // Set fill color to light gray
        translate(width / 2, height / 2); // Center the shapes
        smooth();
        rotate(angle);

        float centerX = width / 2;
        float centerY = height / 2;

        // Drawing the large ellipse
        ellipse(centerX, centerY, 50, 50);

        // Generating and drawing small random ellipses
        for (int i = 0; i < numEllipses; i++) {
            float x2 = random(g.width); // Generate random x-coordinate
            float y2 = random(g.height); // Generate random y-coordinate

            fill(200); // Set fill color to light gray
            ellipse(x2, y2, 10, 10); // Draw ellipse at random location
        }

        // Render rain
        rain.render();
    }

    // Method to get the volume
    public float getVolume() {
        // Implement logic to get the volume value
        // For now, return a constant value
        return 0.5f; // Return a constant value for demonstration
    }

    // Other methods to go here
}
