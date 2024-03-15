package C22737179;

import ie.tudublin.*;

public class BasakVisuals extends Visual {

    
    float x=100*2+200;
    float y=100*2+50;
    float angle;
    int value=300;
    Ellipse ellipse;
    float centerX=height/2+500; // Calculate the center X coordinate
    float centerY=width/2+178;

    
    

    public BasakVisuals() {
        this.ellipse=new Ellipse(x ,y, angle, value);
    }

    float smoothedEllipseSize = 0;
    
    public void draw(CallSet e) {
        //calculateAverageAmplitude();
        this.g = e.getGraphics();
        e.translate(centerX, centerY);
        
         // Initialize the "g" variable
        background(0);
        //translate(g.width/2,g.height/2);

        //float st=map(getAmplitude(),-1,1,0,360);

        //float ellipseSize = 50 + (getAmplitude() * 500);
        //smoothedEllipseSize = lerp(smoothedEllipseSize, ellipseSize, 0.5f);

        ellipse.draw(e);
        
        
    }

}

    



