package C22737179;
import ie.tudublin.*;


public class EllipseDrawer extends Visual {
    private EllipseProperties properties;
    private float smoothedEllipseSize = 0;

    private float strokeWeightMapped;
 
   

    public EllipseDrawer(EllipseProperties properties) {
        this.properties = properties;
        //startTime = millis(); 
        
        
    }

    public void setup() {
        size(1020, 683); // Set the canvas size
        
    }

    

    
  
    
    public void draw(CallSet e) {

        e.translate(e.width/2,e.height/2);
        e.backgroundImage.resize(e.width, e.height);
        e.background(e.backgroundImage);
        

    
        e.calculateAverageAmplitude();
        

        for (float rad = 0; rad < 360; rad += 5) {
            e.pushMatrix();
            e.rotate(radians(rad));
            e.lights();
            //e.stroke(map(rad, 0, 360, 0, 255), 255, 255);
            e.noFill();
            float EllipseSize = 75 + (e.getAmplitude() * 500);
            smoothedEllipseSize = lerp(smoothedEllipseSize, EllipseSize, 0.2f);
         

            //e.pushMatrix();
            e.stroke(map(rad, 0, 255, 0, 360), 255, 255);
            strokeWeightMapped = map(e.getAmplitude(), 0, 1, 1, 5);
            e.strokeWeight(strokeWeightMapped * 2);
            //e.popMatrix();

           
            e.line(properties.x * sin(radians(properties.angle)), 0, 0, properties.y);
            e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), 0, 5, 5);
            e.line(properties.x * sin(radians(properties.angle)), 0, 0, 5, 0, 0);
            //e.popMatrix();


            e.pushMatrix();
            e.rotate(-radians(properties.angle));
            e.ellipse(smoothedEllipseSize* sin(radians(properties.angle)), properties.y, 5, 5);
            //e.triangle(properties.x*sin(radians(properties.angle)), 0, 0, 5, 0, 0);
            e.popMatrix();

            e.pushMatrix();
            e.rotate(radians(properties.angle));
            e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), properties.y + 50, 10, 10);
            e.popMatrix();
            

            //e.stroke(hue, 255, 255);
            e.pushMatrix();
            e.rotate(-radians(properties.angle));
            e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), properties.y + 100, 20, 20);
            e.popMatrix();

            e.pushMatrix();
            
            e.rotate(radians(properties.angle));
            //e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), properties.y + 150, 30, 30);
           
            e.stroke(32, 255, 255);
            //e.stroke(map(rad, 0, 360, 0, 255), 255, 255);
            e.fill(60, 255, 255);
            
            float triangleBaseX = properties.x + 48; 
            float triangleBaseY = properties.y; 
            float triangleHeight = 20; 
            float triangleTopX = properties.x + 10; 
            float triangleTopY = properties.y - triangleHeight; 
            e.triangle(triangleBaseX+40, triangleBaseY+20, triangleTopX, triangleTopY, properties.x +30, properties.y-40);
            //e.stroke(32, 255, 255);
            e.popMatrix();

            e.popMatrix();

          
        }

        properties.angle += 1;
        
    }
}