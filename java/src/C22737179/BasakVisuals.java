package C22737179;

import ie.tudublin.*;
import jogamp.opengl.glu.mipmap.Image;
import processing.core.PImage;

public class BasakVisuals extends Visual {

    
    float x=100*2+100;
    float y=100*2+50;
    float angle;
    int value=300;
    Ellipse ellipse;
    cube2 cube2;

    float height=1.5f;
    float width=1.5f;
    float length=1.5f;
  
    RandomizedCubePattern randomizedCubePattern;


    PImage backgroundImage; // Declare a variable to hold the background image

   

    // Setup method to load the background image
    
    

    public BasakVisuals() {
        this.ellipse=new Ellipse(x ,y, angle, value);
        this.cube2=new cube2();
        this.randomizedCubePattern=new RandomizedCubePattern();
      
        
       
      
    
    }

    public void setup() {
        randomizedCubePattern.generateRandomCubePattern(null);
    
       
       
        
    }

    
    
    public void draw(CallSet e) {
       
        this.g = e.getGraphics();
        background(0);
        //e.backgroundImage.resize(g.width, g.height);
        //e.background(e.backgroundImage);

        
        //translate(g.width/2,g.height/2);

        colorMode(HSB);
        

        //ellipse.draw(e);
        //cube2.draw(e);
        randomizedCubePattern.draw(e);
     

        
        
    }

}

    



