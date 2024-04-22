package C22737179;

import ie.tudublin.*;
import processing.core.PImage;

public class BasakVisuals extends Visual {

    
    float x=50*2+100;
    float y=80*2+50;
    float angle;
    int value=300;
    Ellipse ellipse;
    cube2 cube2;

    
    PImage backgroundImage;

    

    public BasakVisuals() {
        this.ellipse=new Ellipse(x ,y, angle, value);
        this.cube2=new cube2();
       
    }
    

    
    
    public void draw(CallSet e) {
       
        this.g = e.getGraphics();
        background(0);
       
        //e.translate(e.width/2,e.height/2);
        colorMode(HSB);
        

        //ellipse.draw(e);
        cube2.draw(e);
       
     

        
        
    }

}

    



