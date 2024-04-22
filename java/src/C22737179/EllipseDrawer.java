package C22737179;
import ie.tudublin.*;


public class EllipseDrawer extends Visual {
    private EllipseProperties properties;
    private float smoothedEllipseSize = 0;
    //private float previousVolume = 10;
    private float strokeWeightMapped;
    //private int startTime;
    //private PImage smallCircleImage;
   

    public EllipseDrawer(EllipseProperties properties) {
        this.properties = properties;
        //startTime = millis(); 
        //smallCircleImage = loadImage("sky.jpg");
        
    }

    public void setup() {
        size(1020, 683); // Set the canvas size
        
       
        
    }

    

    
  
    //float hueOffset = 0;
    
    public void draw(CallSet e) {

        //e.translate(e.width/2,e.height/2);
        e.image(e.cloudImage, 0, 0, width, height);
        //e.backgroundImage.resize(e.width, e.height);
        //e.background(e.backgroundImage);
        

    
        e.calculateAverageAmplitude();
        

        for (float a = 0; a < 360; a += 5) {
            e.pushMatrix();
            e.rotate(radians(a));
            e.lights();

            e.noFill();
            float EllipseSize = 75 + (e.getAmplitude() * 1000);
            smoothedEllipseSize = lerp(smoothedEllipseSize, EllipseSize, 0.2f);
         

            // Map amplitude to color values-run one colour in each time
            //float hue =(float) (hueOffset + millis() / 20.0) % 255;
            //e.stroke(hue, 255, 255);
      
            
            e.stroke(map(a, 0, 360, 0, 255), 255, 255);
            strokeWeightMapped = map(e.getAmplitude(), 0, 1, 1, 5);
            e.strokeWeight(strokeWeightMapped * 2);

            //int elapsedTime = millis() - startTime;

            // Check if 10 seconds have passed
           // if (elapsedTime >= 10000) {
                //e.strokeWeight(strokeWeightMapped*4);
            // Perform changes here after 10 seconds
          // }

            e.line(properties.x * sin(radians(properties.angle)), 0, 0, properties.y);
            e.ellipse(smoothedEllipseSize * sin(radians(properties.angle)), 0, 5, 5);
            e.line(properties.x * sin(radians(properties.angle)), 0, 0, 5, 0, 0);


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
            //e.fill(255, 255, 0);
            
            float triangleBaseX = properties.x + 48; // Üçgenin tabanının x koordinatı
            float triangleBaseY = properties.y; // Üçgenin tabanının y koordinatı
            float triangleHeight = 20; // Üçgenin yüksekliği (tabandan tepeye kadar olan mesafe)
            float triangleTopX = properties.x + 10; // Üçgenin tepe noktasının x koordinatı
            float triangleTopY = properties.y - triangleHeight; // Üçgenin tepe noktasının y koordinatı
            e.triangle(triangleBaseX+40, triangleBaseY+20, triangleTopX, triangleTopY, properties.x +30, properties.y-40);
            e.popMatrix();

            e.popMatrix();

          
        }

        properties.angle += 1;
        
    }
}