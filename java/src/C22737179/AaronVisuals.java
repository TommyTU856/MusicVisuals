package C22737179;

import ie.tudublin.*;

public class AaronVisuals extends Visual 
{
    
    float angle = 0.0f;
    float offset = 60;
    float scalar = 2;
    float speed = 0.05f;


    public void draw(CallSet e) 
    {
        
        this.g = e.getGraphics(); // Initialize the "g" variable
        background(0);
        stroke(255);
        smooth();
        fill(0);
        rotate(angle);
        float x = offset + cos(angle) * scalar;
        float y = offset + sin(angle) * scalar;
        ellipse( x, y, 100, 100);
        angle += speed;
        scalar += speed;

       



        
        }


    }


