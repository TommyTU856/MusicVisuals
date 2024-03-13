package C22737179;

import processing.core.PApplet;

public class DrawRobot {

    PApplet pa; // Declare a PApplet variable

    public DrawRobot(PApplet pa) {
        this.pa = pa; // Initialize the PApplet variable
    }

    public void drawRobot(int x, int y, int bodyHeight, int neckHeight) {
        // Use pa to access PApplet functionality
        pa.colorMode(pa.RGB);
        pa.background(0);

        int radius = 45;
        int ny = y - bodyHeight - neckHeight - radius;
        // Neck
        pa.stroke(102);
        pa.line(x + 2, y - bodyHeight, x + 2, ny);
        pa.line(x + 12, y - bodyHeight, x + 12, ny);
        pa.line(x + 22, y - bodyHeight, x + 22, ny);
        // Antennae
        pa.line(x + 12, ny, x - 18, ny - 43);
        pa.line(x + 12, ny, x + 42, ny - 99);
        pa.line(x + 12, ny, x + 78, ny + 15);
        // Body
        pa.noStroke();
        pa.fill(102);
        pa.ellipse(x, y - 33, 33, 33);
        pa.fill(0);
        pa.rect(x - 45, y - bodyHeight, 90, bodyHeight - 33);
        pa.fill(102);
        pa.rect(x - 45, y - bodyHeight + 17, 90, 6);
        // Head
        pa.fill(0);
        pa.ellipse(x + 12, ny, radius, radius);
        pa.fill(255);
        pa.ellipse(x + 24, ny - 6, 14, 14);
        pa.fill(0);
        pa.ellipse(x + 24, ny - 6, 3, 3);
        pa.fill(153);
        pa.ellipse(x, ny - 8, 5, 5);
        pa.ellipse(x + 30, ny - 26, 4, 4);
        pa.ellipse(x + 41, ny + 6, 3, 3);
    }
}
