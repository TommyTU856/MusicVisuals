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
        fill(255, 255, 0);
        translate(width/2, height/2); // Center the shapes
        smooth();
        
        rotate(angle);
        float x = offset + cos(angle) * scalar;
        float y = offset + sin(angle) * scalar;
        float x1 = offset + cos(angle) * scalar;
        float y1 = offset + sin(angle) * scalar;


        int radius = 40;
        //float x1 = 110f;
        float speed = 0.05f;
        int direction = 1;
        x1 += speed * direction;
        if ((x1 > width-radius) || (x1 < radius)) {
          direction = -direction;  // Flip direction
        }
        if (direction == 1) {
          circle(x1, y1, x); // Face right
        } else {
          circle(x1, y1, x);  // Face left
        } 

        ellipse(x, y, 100, 100);

        float circleX = x + 10;
        float circleY = y + 10;

        fill(105,0,105);
        ellipse(x+10, y+10, 200, 200);

        fill(205,205,0);
        circle(x1, y1, x1);

        ellipse(circleX, circleY, 200, 200);

        float circleX1 = x1;
        float circleY1 = y1;

        fill(205,205,0);
        circle(circleX1, circleY1, 100); 
        angle += speed;
        scalar += speed;

        translate(-width/4, -height/4); // Move origin to a different location
        fill(0, 255, 0); // Green color
        rect(0, 0, 50, 50); // Draw a rectangle at the new origin

        angle += speed;
        scalar += speed;

        // float x1 = 180;           // X-coordinate
        // float y1 = 400;           // Y-coordinate
        // float bodyHeight = 153;   // Body height
        // float neckHeight = 56;
        // float radius = 45;
        // float angle1 = 0.0f; 

        // ellipseMode(RADIUS);

        // // Change position by a small random amount
        // x1 += random(-4, 4);
        // y1 += random(-1, 1);
        // // Change height of neck
        // neckHeight = 80 + sin(angle1) * 30;
        // angle1 += 0.05;
        // // Adjust the height of the head
        // float ny = y1 - bodyHeight - neckHeight - radius;
        
       
    }
}
