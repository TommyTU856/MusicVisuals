package C22737179;

import ie.tudublin.*;

public class AaronVisuals extends Visual 
{
    
    float angle = 0.0f;
    float offset = 10;
    float scalar = 2;
    float speed = 0.05f;


    public void draw(CallSet e) 
    {
        
        this.g = e.getGraphics(); // Initialize the "g" variable


        colorMode(RGB);
        background(0);


        stroke(255);
        fill(255,255,0);
        translate(width/2, height/2); // Center the shapes
        smooth();
        
        rotate(angle);
        float x = offset + cos(angle) * scalar;
        float y = offset + sin(angle) * scalar;
        ellipse( x, y, 100, 100);
        angle += speed;
        scalar += speed;

       

        float x1 = 180;           // X-coordinate
        float y1 = 400;           // Y-coordinate
        float bodyHeight = 153;  // Body height
        float neckHeight = 56;
        float radius = 45;
        float angle = 0.0f;
        


        
        
        ellipseMode(RADIUS);
        

        // Neck height
        // Head radius
        // Angle for motion

        // Change position by a small random amount
        x1 += random(-4, 4);
        y1 += random(-1, 1);
        // Change height of neck
        neckHeight = 80 + sin(angle) * 30;
        angle += 0.05;
        // Adjust the height of the head
        float ny = y1 - bodyHeight - neckHeight - radius;
        // Neck
        stroke(102);
        line(x+2, y1-bodyHeight, x1+2, ny);
        line(x+12, y1-bodyHeight, x1+12, ny);
        line(x+22, y1-bodyHeight, x1+22, ny);
        // Antennae
        line(x1+12, ny, x1-18, ny-43);
        line(x1+12, ny, x1+42, ny-99);
        line(x1+12, ny, x1+78, ny+15);
        // Body
        noStroke();
        fill(102,100,0);
        ellipse(x1, y1-33, 33, 33);
        fill(0);
        rect(x1-45, y1-bodyHeight, 90, bodyHeight-33);
        fill(205,210,0);
        rect(x1-45, y1-bodyHeight+17, 90, 6);
        // Head
        fill(255);
        ellipse(x1+12, ny, radius, radius);
        fill(255);
        ellipse(x1+24, ny-6, 14, 14);
        fill(255);
        ellipse(x1+24, ny-6, 3, 3);


        
        }


    }


