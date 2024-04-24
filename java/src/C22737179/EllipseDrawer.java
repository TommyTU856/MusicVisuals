package C22737179;
import ie.tudublin.*;


public class EllipseDrawer extends Visual {
    private EllipseProperties properties;
    private float smoothedEllipseSize = 0;

    private float strokeWeightMapped;
 
   
    // Constructor to initialize EllipseDrawer with properties
    public EllipseDrawer(EllipseProperties properties) {
        this.properties = properties;
        //startTime = millis(); 
        
        
    }

    public void setup() {
        size(1020, 683); // Set the canvas size
        
    }

    

    
  
    
    public void draw(CallSet e) {

        e.translate(e.width/2,e.height/2);// Translate to the center of the canvas
        e.backgroundImage.resize(e.width, e.height);//resize the backgorund img
        e.background(e.backgroundImage);//set the backgorund
        

    
        e.calculateAverageAmplitude();//calculate the music amplitude
        

        for (float rad = 0; rad < 360; rad += 5) {
            e.pushMatrix();
            e.rotate(radians(rad));// Rotate by the specified angle
            e.lights();
            //e.stroke(map(rad, 0, 360, 0, 255), 255, 255);
            e.noFill();
            float EllipseSize = 75 + (e.getAmplitude() * 500);//set the siz of ellipse based on the amplitude of the music
            smoothedEllipseSize = lerp(smoothedEllipseSize, EllipseSize, 0.2f);//To make it smooth use lerf fucntion
         

            //e.pushMatrix();
            e.stroke(map(rad, 0, 255, 0, 360), 255, 255);// Set stroke color based on the angle
            strokeWeightMapped = map(e.getAmplitude(), 0, 1, 1, 5);//Make the stroke weight thicker as amplitufe get bigger
            e.strokeWeight(strokeWeightMapped * 2);
            //e.popMatrix();

           
            e.line(properties.x * sin(radians(properties.angle)), 0, 0, properties.y);//This line helps create a visual effect that extends from the center outwards
            e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), 0, 5, 5);//This ellipse adds a circular element to the visual representation
            e.line(properties.x * sin(radians(properties.angle)), 0, 0, 5, 0, 0);//This line creates a shorter extension from the center
            //e.popMatrix();


            e.pushMatrix();
            e.rotate(-radians(properties.angle));//This rotation prepares the canvas for drawing ellipses at different positions
            e.ellipse(smoothedEllipseSize* sin(radians(properties.angle)), properties.y, 5, 5);
            //e.triangle(properties.x*sin(radians(properties.angle)), 0, 0, 5, 0, 0);
            e.popMatrix();

            e.pushMatrix();
            e.rotate(radians(properties.angle));//Restores the canvas rotation to its original state
            e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), properties.y + 50, 10, 10);//draw ellipses getting far away from the center
            e.popMatrix();
            

            //e.stroke(hue, 255, 255);
            e.pushMatrix();
            e.rotate(-radians(properties.angle));
            e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), properties.y + 100, 20, 20);//draw ellipses getting far away from the centerg
            e.popMatrix();

            e.pushMatrix();
            
            e.rotate(radians(properties.angle));
            //e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), properties.y + 150, 30, 30);
           
            e.stroke(32, 255, 255);
            //e.stroke(map(rad, 0, 360, 0, 255), 255, 255);
            e.fill(60, 255, 255);
            
            // Draw triangle
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

        //Increment angle
        properties.angle += 1;
        
    }
}