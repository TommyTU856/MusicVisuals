package C22737179;

import ie.tudublin.*;

public class BasakVisuals extends Visual {

    float x=height*2;
    float y=width*2;
    float angle;
    int value=300;
    

    float smoothedEllipseSize = 0;
    
    public void draw(CallSet e) {
        //calculateAverageAmplitude();

        this.g = e.getGraphics(); // Initialize the "g" variable
        background(0);
        translate(g.width/2,g.height/2);

        //float st=map(getAmplitude(),-1,1,0,360);

        //float ellipseSize = 50 + (getAmplitude() * 500);
        //smoothedEllipseSize = lerp(smoothedEllipseSize, ellipseSize, 0.5f);

        
        
        for(float a=0; a<360; a+=5){
            pushMatrix();
            rotate(radians(a));
            lights();
            

            float col = map(a, 0, 360, 0, 255);
            //float col2 = map(a,0,500,0,250);
            
            noFill();
            
    
            
            stroke(col,value, 200);
            //stroke(map(angle, 0, 1, 0, 255), 255, 255);
            //stroke(255);
            strokeWeight(2);
            
            
            line(x*sin(radians(angle)),0,0,y);
            ellipse(x*sin(radians(angle)),0,5,5);
            triangle(x*sin(radians(angle)), 0, 0, 5, 0, 0);
            
            pushMatrix();
            rotate(-radians(angle)); 
            ellipse(sin(radians(angle)), y, 5, 5);
            popMatrix();

            pushMatrix();
            rotate(radians(angle));
            ellipse(sin(radians(angle)), y+50, 10, 10);
            popMatrix();


            pushMatrix();
            rotate(-radians(angle));
            ellipse(sin(radians(angle)), y+100, 20, 20);
            popMatrix();

            pushMatrix();
            rotate(radians(angle)); 
            ellipse(sin(radians(angle)), y+150, 30, 30);
            popMatrix();
            
            popMatrix();
        }

        angle+=1 ;
        
    }
        
        

    }

    



