package C22737179;

import ie.tudublin.Visual;
import processing.core.PApplet;
import processing.core.PShape;

public class AaronVisuals extends Visual {

    DrawGrid grid;
    Fade fade;
   // Rain rain; // Declare Rain object
    float angle = 0.5f;
    float offset = 0;
    float scalar = 1;
    float speed = 0.02f;
    int numEllipses = 5; // Number of ellipses
    boolean clearScreen = true;
    int shapeColor;
    float cloudX, cloudY = -50;
    float x;
    float y;
    float z;
    Drop[] d;
    
    
    
    public AaronVisuals() {
        // Initialize any required variables or objects here
       // rain = new Rain(this); // Initialize Rain object
    }

    void drawCloud(int x, int y){
        pushMatrix();
        translate(x, y);
        circle (0, 100, 60);
        circle (40, 100, 80);
        circle (80, 100, 60);
        popMatrix();
      }

    

    public void rain(CallSet e) {
        
        d = new Drop[100];
        for (int i = 0; i < d.length; i++) {
            // Start each drop at a random position along the x-axis
            d[i] = new Drop(e.random(e.width), e.random(-e.height, 0), e.random(5), e);
        }

        for (int i = 0; i < d.length; i++) {
            d[i].show();
            d[i].update();
        }    

    }


    public void show() {
        float t = map(z, 0, 5, 10, 2);
        strokeWeight(t);
        line(x, y, x, y + t * 2);
        
        }

    public void update(){
            y = y + 4;
    
            if (y > height + 10) {
                y = -10;
                x = random(width); // Start the drop from a random x-position again
            }
        }

        void cloudObject(float a, float b, float c, float d){
            noStroke();
            fill(120);
            ellipse (a+1530, b+395, c+40, d+30);
            ellipse (a+1510, b+405, c+40, d+30);
            ellipse (a+1460, b+395, c+40, d+30);
            ellipse (a+1480, b+405, c+40, d+30);
            ellipse (a+1470, b+385, c+40, d+30);
            ellipse (a+1510, b+385, c+40, d+30);
            ellipse (a+1490, b+380, c+40, d+30);
            
          }
    
    public void draw(CallSet e) {
        this.g = e.getGraphics(); // Initialize the "g" variable
    
        colorMode(RGB);
        background(0); 
        shapeColor = color(random(255), random(255), random(255)); 
        stroke(255);
        fill(200); // Set fill color to light gray
    
        
    
        // Center the shapes and rotate them
        translate(g.width / 2, g.height / 2); // Center the shapes
        smooth();
        rotate(angle);
    
        float centerX = width / 2;
        float centerY = height / 2;
    
        // Drawing the large ellipse
        //ellipse(centerX, centerY, 150, 150);
        
        rain(e);
        pushMatrix ();
        ellipseMode (CENTER);
        rotate (radians(angle));
        popMatrix ();
        rain(e);
        cloudObject(1500,500,10,10);
        drawCloud(mouseX,mouseY);
    
        // Generating and drawing small random ellipses
        for (int i = 0; i < numEllipses; i++) {
            float x2 = random(g.width); // Generate random x-coordinate
            float y2 = random(g.height); // Generate random y-coordinate
    
            ellipse(x2, y2, 10, 10); // Draw ellipse at random location
            
        }

        

       
    }


    
}
