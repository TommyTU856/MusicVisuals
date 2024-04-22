package C22737179;

import ie.tudublin.*;
import processing.core.PImage;

public class BasakVisuals extends Visual {

    
    float x=80*2+100;
    float y=80*2+50;
    float angle;
    int value=300;
    Ellipse ellipse;
    cube2 cube2;

    
    PImage backgroundImage;
    boolean drawEllipse = true;
    boolean timeStarted = false;
    int startTime;
    int switchTime = 0;


    

    public BasakVisuals() {
        this.ellipse=new Ellipse(x ,y, angle, value);
        this.cube2=new cube2();
       
    }
    

    
    
    public void draw(CallSet e) {
       
        this.g = e.getGraphics();
        background(0);
        
       
        //e.translate(e.width/2,e.height/2);
        colorMode(HSB);
        // Check if 15 seconds have passed
        // Check if it's time to switch
        if (millis() - switchTime > 15000) {
            // Switch the drawing mode
            drawEllipse = !drawEllipse;
            switchTime = millis(); // Update the switch time
        }

        // Draw the appropriate shape
        if (drawEllipse) {
            ellipse.draw(e);
        } else {
            cube2.draw(e);
        }
    }
}
        //ellipse.draw(e);
        //cube2.draw(e);
       


    



