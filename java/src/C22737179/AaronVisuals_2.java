package C22737179;


import ie.tudublin.*;
import processing.core.PApplet;
import ddf.minim.*;

public class AaronVisuals_2 extends Visual {

   
    
    
    
    public AaronVisuals_2()
    {
        
    }

    public void draw(CallSet e) {

        e.background(255, 0xFF, 0); 
		e.stroke(0, 255, 0);
		e.line(10, 10, 100, 100); // x1, y1, x2, y2
		e.fill(90, 0, 0);
		e.ellipse(200, 90, 80, 200); // cx, cy
		e.circle(200, 300, 80);
		e.fill(90, 78, 88);
		e.rect(400, 380, 50, 100); // x, y, w, h
		e.triangle(10, 200, 200, 200, 300, 400);

       
    }
}
