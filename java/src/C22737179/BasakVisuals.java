package C22737179;

import ie.tudublin.*;

public class BasakVisuals extends Visual {

    float x=300;
    float y=300;
    float angle;
    

    //float smoothedEllipseSize = 0;
    
    public void render(CallSet e) {
        //calculateAverageAmplitude();

        this.g = e.getGraphics(); // Initialize the "g" variable
        //stroke(255);
        //line(50, 450, 400, 750);
        //calculateAverageAmplitude();
        background(0);
        translate(width*3,height*3);

        

        for(float a=0; a<360; a+=10){
            pushMatrix();
            rotate(radians(a));
            lights();

            float col = map(angle, 0, 700, 0, 255);
           // float col2 = map(a,0,500,0,250);
            

            //float ellipseSize = 50 + (getAmplitude() * 300);
            //smoothedEllipseSize = lerp(smoothedEllipseSize, ellipseSize, 0.1f);
    
            
            stroke(col,120, 255);
            // stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            //stroke(255);
            strokeWeight(1);
            
            
            line(x*sin(radians(angle)),0,0,y);

            ellipse(x*sin(radians(angle)),0,10,10);

            triangle(x * sin(radians(angle)), 0, 0, 5, 0, 0);

            ellipse(0,y,10,10);
            
            popMatrix();
        }

        angle+=1;
    }
        
        

    }

    



