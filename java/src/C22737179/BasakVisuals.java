package C22737179;

import ie.tudublin.*;
import processing.core.PImage;

public class BasakVisuals extends Visual {

    
    float x=100*2+100;
    float y=100*2+50;
    float angle;
    int value=300;
    Ellipse ellipse;
    CandleSticks candleSticks;


    PImage backgroundImage; // Declare a variable to hold the background image

   

    // Setup method to load the background image
    
    

    public BasakVisuals() {
        this.ellipse=new Ellipse(x ,y, angle, value);
        //this.backgroundImage=new PImage();
      
        //this.candleSticks=new CandleSticks();
    }

    public void setup() {
        //size(1020, 683); // Set the canvas size
        //backgroundImage = loadImage("sky2.jpg");
        
        
        //backgroundImage = loadImage("C:\\Desktop\\basak\\collob\\data\\sky2.jpg"); // Load the background image
       
        
    }

    
    
    public void draw(CallSet e) {
       
        this.g = e.getGraphics();
        //background(0);
        e.backgroundImage.resize(g.width, g.height);
        e.background(e.backgroundImage);

        //image(backgroundImage, 0, 0);
        //print(backgroundImage);
        //System.out.println("Image width: " + backgroundImage.width);
        //System.out.println("Image height: " + backgroundImage.height);
        translate(g.width/2,g.height/2);

        colorMode(HSB);
        //candleSticks.draw(e);

        ellipse.draw(e);
        
        
    }

}

    



