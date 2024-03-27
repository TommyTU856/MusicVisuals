package C22737179;

import ie.tudublin.*;
import processing.core.PShape;

public class AaronVisuals extends Visual {
    DrawGrid grid;
    TimeClock timeClock;
    Fade fade;

    float angle = 0.5f;
    float offset = 0;
    float scalar = 1;
    float speed = 0.02f;

    int numEllipses = 70; // Number of ellipses
    float[][] ellipses = new float[numEllipses][4]; // Array to store ellipse coordinates and color

    boolean clearScreen = true;
    int shapeColor;

    public AaronVisuals() {
    }

    public void draw(CallSet e) {
        this.g = e.getGraphics(); // Initialize the "g" variable
        //grid = new DrawGrid(this);
        timeClock = new TimeClock(this);
        fade = new Fade(100, 100, 1000, this); // Initialize Fade object with specific values

        colorMode(RGB);
        if (clearScreen) {
            background(0); // Use color() function for background color (black)
            clearScreen = false;
            shapeColor = color(random(255), random(255), random(255));
        }

        fade.update();
        fade.display();
        timeClock.drawTimeClock();

        stroke(255);
        fill(200); // Set fill color to light gray
        translate(width / 2, height / 2); // Center the shapes
        smooth();
        rotate(angle);

        float centerX = width / 2;
        float centerY = height / 2;
        float x = centerX;
        float y = centerY;

        // Drawing the large ellipse
        ellipse(x, y, 50, 50);

        // Generating and drawing small random ellipses
        for (int i = 0; i < numEllipses; i++) {
            float x2 = random(g.width); // Generate random x-coordinate
            float y2 = random(g.height); // Generate random y-coordinate

            fill(200); // Set fill color to light gray
            ellipse(x2, y2, 10, 10); // Draw ellipse at random location
        }

        float x1 = 110f;
        float y1 = 110f;

        x1 += speed * 2;
        y1 += speed * 2;

        triangle(x1, y1, x, y, x, y);
        ellipse(250, -250, 100, 100);
        float circleX = x + 10;
        float circleY = y + 10;

        fill(200); // Set fill color to light gray
        ellipse(150, -150, 200, 200);
        fill(200); // Set fill color to light gray
        circle(300, -300, x1);
        fill(200); // Set fill color to light gray
        ellipse(circleX, -circleY, 250, 250);

        float circleX1 = x1;
        float circleY1 = y1;

        fill(200); // Set fill color to light gray
        circle(circleX1, -circleY1, 220);
        angle += speed;
        scalar += speed;

        translate(-width / 3, -height / 3); // Move origin to a different location
        fill(200); // Set fill color to light gray
        rect(400, -400, 150, 150); // Draw a rectangle at the new origin

        angle += speed;
        //drawGrid(g.width / 3, height / 3, width, height); // Draw grid
    }

    // void drawGrid(int x, int y, int width, int height) {
    //     for (int gridY = 0; gridY < height; gridY += height / 10) {
    //         for (int gridX = 0; gridX < width; gridX += width / 10) {
    //             this.line(gridX, gridY, gridX + width / 10, gridY + height / 10);
    //             this.line(gridX + width / 10, gridY, gridX, gridY + height / 10);
    //         }
    //     }
    // }
}
