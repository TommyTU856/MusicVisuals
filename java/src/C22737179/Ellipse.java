package C22737179;
import ie.tudublin.*;

public class Ellipse extends Visual {

    float x;//height
    float y;//width
    float angle;
    int value;
    float value2;
  ;

    

    public Ellipse(float x, float y, float angle, int value) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.value = value;
        this.value2=x*sin(radians(angle));
        

    }

    float smoothedEllipseSize = 0;
    float previousVolume=10;
    
    float strokeWeightMapped;
    float radianss=-radians(angle);

    void draw(CallSet e){

        e.calculateAverageAmplitude();
        float currentVolume = e.getAmplitude();

    
        float rotationDirection = currentVolume > previousVolume ? 1 : -1;
    
    
        previousVolume = currentVolume;
        //previousAmplitude = e.getAmplitude(); // Store current amplitude for next iteration
    


        for(float a=0; a<360; a+=5){
               
            e.pushMatrix();
            
            e.rotate(radians(a*rotationDirection));
            e.lights();
            

            //float col = map(a, 0, 360, 0, 255);
            
            e.noFill();
            float EllipseSize = 50 + (e.getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
            smoothedEllipseSize = lerp(smoothedEllipseSize, EllipseSize, 0.2f);
           
    
            
            e.stroke(map(a,0, 360, 0, 255),value, 200);
            //stroke(map(angle, 0, 1, 0, 255), 255, 255);
            strokeWeightMapped = map(e.getAmplitude(), 0, 1, 1, 5);
            e.strokeWeight(strokeWeightMapped*2);
           
            
          
            e.line(x*sin(radians(angle)),0,0,y);
            e.ellipse(smoothedEllipseSize*sin(radians(angle)),0,5,5);
            e.triangle(x*sin(radians(angle)), 0, 0, 5, 0, 0);

            
            
            e.pushMatrix();
            e.rotate(-radians(angle)); 
            e.ellipse(smoothedEllipseSize*sin(radians(angle)), y, 5, 5);
            e.popMatrix();

            e.pushMatrix();
            e.rotate(radians(angle));
            e.ellipse(smoothedEllipseSize*sin(radians(angle)), y+50, 10, 10);
            e.popMatrix();


            e.pushMatrix();
            e.rotate(-radians(angle));
            e.ellipse(smoothedEllipseSize*sin(radians(angle)), y+100, 20, 20);
            e.popMatrix();

            e.pushMatrix();
            e.rotate(radians(angle)); 
            e.ellipse(smoothedEllipseSize*sin(radians(angle)), y+150, 30, 30);
            e.popMatrix();
            
            e.popMatrix();
        }

        angle+=1 ;
        
       
        
    }

}
    

