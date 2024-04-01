package C22737179;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.Visual;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;

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
    int cloudNumber = 20;
    Cloud[] clouds;
    float cloudSpeed = 1.5f;
    String[] words = {"Clouds", "World", "Fluffy", "Little", "Cloud", "Everwhere", "Floating"};
    int numWords = 7;
    float[] xPositions, yPositions;
    float[] xSpeeds, ySpeeds;

    public AaronVisuals() {
        // Initialize any required variables or objects here
       // rain = new Rain(this); // Initialize Rain object
       clouds = new Cloud[cloudNumber];
       

       for (int i = 0; i < cloudNumber; i++) {
        float a = random(20, 80);
        float x;

        // Randomize between left and right sides of the screen
        if (random(1) > 0.5) {
            x = random(width / 2) - a; // Random x-coordinate on the left half of the screen
        } else {
            x = random(width / 2, width - a); // Random x-coordinate on the right half of the screen
        }
        float y = random(height); // Random y-coordinate
        float radius = random(40, 100); // Random radius for cloud size   
        float b = random(10, 60);
        clouds[i] = new Cloud(x, y, radius, a, b);



        }

        xPositions = new float[numWords];
        yPositions = new float[numWords];
        xSpeeds = new float[numWords];
        ySpeeds = new float[numWords];

        for (int i = 0; i < numWords; i++) {
            xPositions[i] = random(width);
            yPositions[i] = random(height);
            xSpeeds[i] = random(-2, 2);
            ySpeeds[i] = random(-2, 2);
        }

        
    }

    // void drawCloud(int x, int y){
    //     pushMatrix();
    //     translate(x, y);
    //     circle (0, 100, 60);
    //     circle (40, 100, 80);
    //     circle (80, 100, 60);
    //     popMatrix();
    //   }

    

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


    public void show(CallSet e) {
        float t = map(z, 0, 5, 10, 2);
        strokeWeight(t);
        line(x, y, x, y + t * 2);
        
        }

    public void update(CallSet e){
            y = y + 4;
    
            if (y > height + 10) {
                y = -10;
                x = random(width); // Start the drop from a random x-position again
            }
        }

        void cloudObject(float a, float b, float c, float d){
            noStroke();
            fill(200);
            // ellipse (a+1530, b+395, c+40, d+30);
            // ellipse (a+1510, b+405, c+40, d+30);
            // ellipse (a+1460, b+395, c+40, d+30);
            // ellipse (a+1480, b+405, c+40, d+30);
            // ellipse (a+1470, b+385, c+40, d+30);
            // ellipse (a+1510, b+385, c+40, d+30);
            // ellipse (a+1490, b+380, c+40, d+30);
            ellipse (x - 20, y, c, d); // Adjusting the x-coordinate to center the cloud
            ellipse (x + 20, y, c, d); // Adjusting the x-coordinate to center the cloud
            ellipse (x, y - 10, c, d); // Adjusting the y-coordinate to slightly raise the cloud
          }
    
    public void draw(CallSet e) {
        this.g = e.getGraphics(); // Initialize the "g" variable
    
        colorMode(RGB);
        background(0); 
        shapeColor = color(random(255), random(255), random(255)); 
        stroke(255);
        fill(200); // Set fill color to light gray
    
        
    
        // Center the shapes and rotate them
        translate(width / 2, height / 2); // Center the shapes
        smooth();
        //rotate(angle);
    
        // float centerX = width / 2;
        // float centerY = height / 2;
    
        // Drawing the large ellipse
        //ellipse(centerX, centerY, 150, 150);
        
        rain(e);


        // pushMatrix ();
        // ellipseMode (CENTER);
        // rotate (radians(angle));
        // popMatrix ();
        // rain(e);
        //cloudObject(1500,500,10,10);
        //drawCloud(mouseX,mouseY);


        

        for (int i = 0; i < numWords; i++) {
            textSize(30);
            fill(255);
            text(words[i], xPositions[i], yPositions[i]);

            xPositions[i] += xSpeeds[i];
            yPositions[i] += ySpeeds[i];

            if (xPositions[i] > width || xPositions[i] < 0) {
                xSpeeds[i] *= -1;
            }
            if (yPositions[i] > height || yPositions[i] < 0) {
                ySpeeds[i] *= -1;
            }
        }

        for (int i = 0; i < cloudNumber; i++) {
            // Update the x-coordinate of each cloud
            clouds[i].move(cloudSpeed);
            // Draw the cloud at its updated position
            clouds[i].display(e);
        }
    
        // Generating and drawing small random ellipses
        for (int i = 0; i < numEllipses; i++) {
            float x2 = random(g.width); // Generate random x-coordinate
            float y2 = random(g.height); // Generate random y-coordinate
    
            ellipse(x2, y2, 10, 10); // Draw ellipse at random location
            
        }  
    }

    class Cloud {
        float x, y; // Position of the cloud
        float radius; // Size of the cloud
        float a, b; // Shape parameters for the cloud

        Cloud(float x, float y, float radius, float a, float b) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.a = a;
            this.b = b;
        }

        void move(float cloudSpeed) {
            x += cloudSpeed; // Move the cloud horizontally
            if (x < -radius) {
                x = width + radius;
                y = random(height);
            }
        }

        void display(CallSet e) {
            fill(255);
            ellipse(x - 20, y, a, b);
            ellipse(x + 20, y, a, b);
            ellipse(x, y - 10, a, b);
        }
    }
}





// Minim minim;
//     AudioPlayer player;
//     PVector[] particles;
//     int numParticles = 100;
//     PVector[] particleVelocities;
//     PVector gravity;
//     float[] fft;
//     float[] bands;
//     int numBands = 512;



// size(800, 600);
//         minim = new Minim(this);
//         player = minim.loadFile("music.mp3");
//         player.play();

//         particles = new PVector[numParticles];
//         particleVelocities = new PVector[numParticles];
//         for (int i = 0; i < numParticles; i++) {
//             particles[i] = new PVector(random(width), random(height));
//             particleVelocities[i] = new PVector(random(-2, 2), random(-2, 2));
//         }

//         gravity = new PVector(0, 0.1);

//         fft = new float[numBands];
//         bands = new float[numBands];
//     }



// fft.forward(player.mix);
//         for (int i = 0; i < numBands; i++) {
//             bands[i] = fft.getBand(i);
//         }


// for (int i = 0; i < numParticles; i++) {
//     particleVelocities[i].add(gravity);
//     particles[i].add(particleVelocities[i]);
//     particles[i].x = constrain(particles[i].x, 0, width);
//     particles[i].y = constrain(particles[i].y, 0, height);

//     float radius = map(bands[i], 0, 1, 1, 10);
//     fill(map(bands[i], 0, 1, 0, 255));
//     ellipse(particles[i].x, particles[i].y, radius, radius);
// }


// size(800, 600);
//         kinect = new SimpleOpenNI(this);
//         kinect.enableDepth();

//         leap = new Controller();
//         leap.addListener(new LeapMotionListener());

//         handPositions = new PVector[2];
    

//         background(0);

//         // Kinect
//         if (kinect.isInit()) {
//             PImage depthImage = kinect.depthImage();
//             image(depthImage, 0, 0);
//         }
// for (int i = 0; i < handPositions.length; i++) {
//             if (handPositions[i] != null) {
//                 fill(255, 0, 0);
//                 ellipse(handPositions[i].x, handPositions[i].y, 50, 50);


//                 class LeapMotionListener extends Listener {
//                     public void onFrame(Controller controller) {
//                         Frame frame = controller.frame();
//                         HandList hands = frame.hands();
//                         for (int i = 0; i < hands.count(); i++) {
//                             Hand hand = hands.get(i);
//                             Vector position = hand.palmPosition();
//                             float x = map(position.getX(), -200, 200, 0, width);
//                             float y = map(position.getY(), 0, 600, 0, height);
//                             handPositions[i] = new PVector(x, y);
//                         }