package C22737179;

import ie.tudublin.*;

public class TommyVisuals extends Visual{

    float angle = 0;
    float radius = 150;
    float lineLength = 100;
    float rotationSpeed = 0.02f;

    void drawSphere() {
        pushMatrix();
        rotateY(angle);
        fill(200, 0, 0); // Red color for the sphere
        sphere(50); // Adjust the size of the sphere as needed
        popMatrix();
    }



    public void draw(CallSet e) {
        
        this.g = e.getGraphics();
        lights();
        background(255);
        //println(g.width + " " + g.height);
        translate(g.width / 2, g.height / 2);
        drawSphere();
        
    }
}