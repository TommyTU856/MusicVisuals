package C22737179;

import java.util.ArrayList;
import java.util.Iterator;

import C22737179.AaronVisuals.Cloud;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ie.tudublin.Visual;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import processing.*;
import processing.core.PGraphics; // Import the PGraphics class



public class AaronVisuals extends Visual {

    // Declare variables and objects

    // Minim audio objects
    Minim minim;
    AudioInput in;
    FFT fft;

    // Visual elements
    DrawGrid grid;
    Fade fade;
    PShape mountainClouds;
    PImage img; // Declare a variable to hold the background image
    TimeClock timeClock;
    
    
    

    // Cloud variables
    int numClouds = 40;
    Cloud[] clouds;
    float cloudSpeed = 1.5f;

    // Word variables
    String[] words;
    int numWords;
    float[] xPositions, yPositions;
    float[] xSpeeds, ySpeeds;

    //Rain Variable
    Drop[] d;

    //Draw Variables
    int currentImageIndex = 0; // Index to keep track of the current image or visual element
    int frameCountThreshold = 60 * 10; // Change the image every 10 seconds (60 frames per second)
    VisualElement[] visualElements; 

    //Colours
    int inside, middle, outside;
    int OFF_MAX = 300;
    int c1, c2, c3, c4, c5, c6;

   
    

    PShape clouds_obj;
    float angle = 0.5f;
    float offset = 0;
    float scalar = 1;
    float speed = 0.02f;
    int numEllipses = 5;
    boolean clearScreen = true;
    int shapeColor;
    float cloudX, cloudY = -50;
    float x;
    float y;
    float z;
   
    int cloudNumber = 40;
    
    
    float[] lerpedBuffer;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    
    float xSpeed = 7;
    float ySpeed = 7;
    //Shape p;
    int cloudColor;

   

    

 

    final int N_FRAMES = 200;
    PFont jgs5;

    
    
    

    String[][] lyrics = {
        {"Over the past few years"},
        {"To the traditional sounds of the English summer"},
        {"The drone of lawnmowers"},
        {"The smack of leather on willow"},
        {"Has been added a new noise"},
        {"What were the skies like when you were young?"},
        {"They went on forever and they, when I, we lived in Arizona"},
        {"And the skies always had little fluffy clouds in them and, er"},
        {"They were long and clear and"},
        {"There were lots of stars at night"},
        {"And, er, when it would rain it would all turn, it, they were beautiful"},
        {"The most beautiful skies, as a matter of fact"},
        {"Uh, the sunsets were"},
        {"Purple and red and yellow and on fire"},
        {"And the clouds would catch the colors everywhere"}
    };

    // Functional interface for visual elements
    interface VisualElement {
        void draw(CallSet e);
    }


    public void mountainClouds(CallSet e) {
        
        pushMatrix();
        e.calculateAverageAmplitude();    
        mountainClouds(e);
        popMatrix();
    }

    // Constructor
    public AaronVisuals() {


        minim = new Minim(this);
        in = minim.getLineIn();
        fft = new FFT(in.bufferSize(), in.sampleRate());

        // Initialize variables and objects
        clouds = new Cloud[cloudNumber];
        grid = new DrawGrid(this);
        Word word1 = new Word("example");
        timeClock = new TimeClock(this);
        

        
        
         
        
        //fade = new Fade(this);

        //Follow follow = new Follow("followingWord");
        //word1.follows.add(follow);

        
          
        
       
        // Initialize clouds
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
            int cloudColor = color(random(200, 255), random(200, 255), random(200, 255)); // Generate random bright cloud color
            clouds[i] = new Cloud(x, y, radius, a, b, cloudColor);
        }


        words = new String[] {"Clouds", "World", "Fluffy", "Little", "Cloud", "Everwhere", "Floating", "And", "skies", "always", "little",
            "fluffy", "clouds", "They", "were", "long", "clear","Over the past few years","What were the skies like when you were young?",
            "And, er, when it would rain it would all turn, it, they were beautiful","They went on forever and they, when I, we lived in Arizona"};
        numWords = words.length;

        // Initialize arrays for word positions and speeds
        xPositions = new float[numWords];
        yPositions = new float[numWords];
        xSpeeds = new float[numWords];
        ySpeeds = new float[numWords];

        // Initialize word positions and speeds
        for (int i = 0; i < numWords; i++) {
            xPositions[i] = random(0, width);
            yPositions[i] = random(0, height);
            xSpeeds[i] = random(-5, 5);
            ySpeeds[i] = random(-5, 5);
        }

         // Initialize colors
         inside = color(204, 102, 0);
         middle = color(204, 153, 0);
         outside = color(153, 51, 0);

         //Initialise visual elements array
         //visualElements = new VisualElement[] { this::drawWords, this::rain, this::spiralShape, this::formCloud,this::boxes, this::rain, this::boxes, this::visualCube, this::drawWords, this::mountainClouds, this::circles  }; // Define your visual elements


    }


        // Draw Method
        public void draw(CallSet e) {


            this.g = e.getGraphics(); // Initialize the "g" variable

            // Calculate the amplitude of the audio
            float amplitude = getSmoothedAmplitude();
    
            // Map the amplitude to the background color
            float colorChange = map(amplitude, 0, 1, 0, 255);
            e.colorMode(HSB, 360, 200, 300);
            e.background(0, 0, 0);

            // Perform FFT analysis
            fft.forward(in.mix);

            
            
    
        //Audio code 

         if(e.getAudioPlayer().position() > 1 && e.getAudioPlayer().position() < 10000 && !e.paused) {
            e.calculateAverageAmplitude();

            pushMatrix();
            
            popMatrix();

            pushMatrix();
            e.background(colorChange += (50 * getSmoothedAmplitude()),0,0);
            timeClock.drawTimeClock();
            popMatrix();  
            
            
        }

        if(e.getAudioPlayer().position() > 10000 && e.getAudioPlayer().position() < 36000 && !e.paused) {
            e.calculateAverageAmplitude();
           
             // Map the amplitude to the background color
            colorChange = map(amplitude, 0, 1, 0, 255);
            pushMatrix();
            e.background(colorChange += (50 * getSmoothedAmplitude()),0,0);

            drawWords(e);
            timeClock.drawTimeClock();
            popMatrix();



            // pushMatrix();
            // stars(e);
            // popMatrix();
            
            //e.background(colorChange += (255 * getSmoothedAmplitude()),1,0); 
            //e.background(colorChange, 0, 255 - colorChange);
            //popMatrix();
            
            
        }

        if(e.getAudioPlayer().position() > 36000 && e.getAudioPlayer().position() < 38000 && !e.paused) {
            
           
            
            pushMatrix();
            e.background(HSB,314, 95, 72);//Purple
            formCloud(e);
            popMatrix();
            

           
        }
        if(e.getAudioPlayer().position() > 38000 && e.getAudioPlayer().position() < 40000 && !e.paused) {
            

            pushMatrix();
            e.background(HSB,106, 95, 72); // Green
            formCloud(e);
            popMatrix();

            pushMatrix();
            boxes(e);
            popMatrix();

        }
        if(e.getAudioPlayer().position() > 40000 && e.getAudioPlayer().position() < 42000 && !e.paused) {
           
            pushMatrix();
            e.background(HSB,8,93,89);//red
            formCloud(e);
            popMatrix();

            pushMatrix();
            boxes(e);
            popMatrix();

        }
        if(e.getAudioPlayer().position() > 42000 && e.getAudioPlayer().position() < 50000 && !e.paused) {
            
            pushMatrix();
            e.background(HSB,255, 255, 0); // Yellow
            formCloud(e);
            popMatrix();

            pushMatrix();
            boxes(e);
            popMatrix();

            pushMatrix();
            circles(e);
            popMatrix();

        }

        if(e.getAudioPlayer().position() > 50000 && e.getAudioPlayer().position() < 56000 && !e.paused) {

            e.calculateAverageAmplitude();
            //e.background(colorChange += (50 * getSmoothedAmplitude()),0,0);
            
             

            pushMatrix();
            formCloud(e);
            popMatrix();

            pushMatrix();
            stars(e);
            popMatrix();

        }
        

        if(e.getAudioPlayer().position() > 56000 && e.getAudioPlayer().position() < 67000 && !e.paused) {
            e.calculateAverageAmplitude();
            e.background(0, 87, 94);


         
            pushMatrix();
            rain(e);
            popMatrix();

            pushMatrix();
            stars(e);
            popMatrix();

            pushMatrix();
            cloudyShapes(e);
            popMatrix();

            
    

        }

        if(e.getAudioPlayer().position() > 67000 && e.getAudioPlayer().position() < 90000 && e.paused == false) {
            e.calculateAverageAmplitude();
            

            pushMatrix();
            formCloud(e);
            popMatrix();

            pushMatrix();
            visualCube(e);
            popMatrix();

            pushMatrix();
            spiralShape(e);
            popMatrix();

            pushMatrix();
            e.calculateAverageAmplitude();
            noStroke();
            translate(130, height/2, 0);
            rotateY(1.25f);
            rotateX(-0.4f);
            fill(random(255),random(255),random(255));
            box(100);
            popMatrix();
            

        }

        if(e.getAudioPlayer().position() > 90000 && e.getAudioPlayer().position() < 100000 && e.paused == false) {
            
            pushMatrix();
            visualCube(e);
            popMatrix();

        }

        if(e.getAudioPlayer().position() > 100000 && e.getAudioPlayer().position() < 120000 && e.paused == false) {
            pushMatrix();
            rain(e);
            popMatrix();

            pushMatrix();
            visualCube(e);
            popMatrix();

        }

        if(e.getAudioPlayer().position() > 120000 && e.getAudioPlayer().position() < 140000 && e.paused == false) {

            
            pushMatrix();
            rain(e);
            popMatrix();
    
            pushMatrix();
            circles(e);
            popMatrix();

            pushMatrix();
            visualCube(e);
            popMatrix();
            
            
        }

        if(e.getAudioPlayer().position() > 140000 && e.getAudioPlayer().position() < 160000 && e.paused == false) {
            pushMatrix();
            rain(e);
            popMatrix();

            pushMatrix();
            fill(random(255));
            lyricsStart(e);
            popMatrix();


            
        }

        if(e.getAudioPlayer().position() > 160000 && e.getAudioPlayer().position() < 180000 && e.paused == false) {
            
            pushMatrix();
            visualCube(e);
            popMatrix();

            pushMatrix();
            spiralShape(e);
            popMatrix();




        }

        if(e.getAudioPlayer().position() > 180000 && e.getAudioPlayer().position() < 200000 && e.paused == false) {
            pushMatrix();
            drawWords(e);
            rain(e);
            popMatrix();

            pushMatrix();
            fill(random(255));
            lyricsStart(e);
            popMatrix();
        }

        if(e.getAudioPlayer().position() > 200000 && e.getAudioPlayer().position() < 300000 && e.paused == false) {

            pushMatrix();
            visualCube(e);
            popMatrix();

        }

        if(e.getAudioPlayer().position() > 300000 && e.getAudioPlayer().position() < 400000 && e.paused == false) {

            pushMatrix();
            visualCube(e);
            popMatrix();
            
 
        }


        if(e.getAudioPlayer().position() > 400000  && e.getAudioPlayer().position() < 900000 && e.paused == false) {
            
            pushMatrix();
            visualCube(e);
            spiralShape(e);
            popMatrix();
    
 
        } 

        if(e.getAudioPlayer().position() > 900000  && e.getAudioPlayer().position() < 1000000 && e.paused == false) {
            
            pushMatrix();
            visualCube(e);
            spiralShape(e);
            boxes(e);
            popMatrix();

            pushMatrix();
            int cols = mouseX;
                    noStroke();
                    
                    float x = random(width);
                    float y = random(height);
                    
                    for (float size = random(25, 100); size >= 0; size -= random(2, 10)) {
                        fill(random(345), random(358), random(360));
                        ellipse(x, y, size, size);
                    }
            popMatrix();
    
 
        } 

                
       }


    

        public void lyricsStart(CallSet e){
        pushMatrix();
            translate(width / 2, height / 2); // Center the text
            
            textAlign(CENTER);
            textSize(34);
            for (int i = 0; i < lyrics.length; i++) {
                for (int j = 0; j < lyrics[i].length; j++) {
                    String line = lyrics[i][j];
                    for (int k = 0; k < line.length(); k++) {
                        char character = line.charAt(k);
                          
                        text(character, 0, i * 30); // Adjust position and spacing as needed
                        // Increment the x-coordinate for the next character
                        translate(textWidth(character), 0);
                    }
                    // Move to the next line
                    translate(-textWidth(line), 30);
                }
            }
            popMatrix();

        }
    

        public void cloudyShapes(CallSet e){
            // Draw clouds
            pushMatrix();
            fill(random(255),random(255),random(255));
            e.calculateAverageAmplitude(); 
            translate(e.width / 2, e.height / 2);
            for (int i = 0; i < cloudNumber; i++) {
                rotate(20);
                rotateX(0.5f);
                // Update the x-coordinate of each cloud
                clouds[i].move(cloudSpeed);
                rotateY(1.0f);
                // Draw the cloud at its updated position
                clouds[i].display(e);
            }
            popMatrix();  
        }

        

        public void spiralShape(CallSet e) {
            
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            e.calculateAverageAmplitude(); 
            int num = 40;
            int circles = 20;
            float theta = 0; // Initialize theta
            background(20);
            fill(255, 50);
            stroke(0, 150);
            strokeWeight(2);
            for (int i = 0; i < circles; i++) {
                spiralShape(e, 180 - i * 5, PI / circles * i);
            }
            theta += 0.0523;
            
        }
        
        void spiralShape(CallSet e, float radius, float offSet) {
            e.calculateAverageAmplitude(); 
            int num = 40; // Move num variable inside drawWobble
            float theta = e.frameCount * 0.01f; // Adjust theta calculation
            beginShape();
            for (int i = 0; i < num; i++) {
                float x = (float) (e.width / 2 + cos(TWO_PI / num * i + offSet) * radius * 1.2);
                float y = e.height / 2 + sin(TWO_PI / num * i + offSet) * radius;
                float xp = map(sin(theta + (TWO_PI / num * i)), -1, 1, -20, 60);
                float yp = map(cos(theta + (TWO_PI / num * i) * 2), -1, 1, -30, 0);
                if (i == 0) {
                    e.curveVertex(x + xp, y + yp);
                }
                e.curveVertex(x + xp, y + yp);
                if (i == num - 1) {
                    e.curveVertex(x + xp, y + yp);
                }
            }
            endShape(CLOSE);
        }

        public void stars(CallSet e) {
            
            
            for (int i = 0; i < 50; i++) {
                float x = random(e.width); // Random x-coordinate within canvas width
                float y = random(e.height); // Random y-coordinate within canvas height
                float radius = random(1, 5); // Random radius between 1 and 5
                
                drawStar(x, y, radius);
            }
        }
        
        void drawStar(float x, float y, float radius) {
            beginShape();
            
            for (int i = 0; i < 10; i++) {
                float angle = TWO_PI / 10 * i;
                float x1 = x + cos(angle) * radius;
                float y1 = y + sin(angle) * radius;
                vertex(x1, y1);
                
                angle += TWO_PI / 20;
                float x2 = x + cos(angle) * radius * 0.5f; // Make the inner radius smaller for the star tips
                float y2 = y + sin(angle) * radius * 0.5f;
                vertex(x2, y2);
            }
            endShape(CLOSE);
        }
        


    public void visualCube(CallSet e){

        

        //e.background(0);
        e.translate(e.width / 2, e.height / 2, -OFF_MAX);
        pushMatrix();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        e.rotateX(e.frameCount * .01f);
        e.rotateY(e.frameCount * .01f);
        e.rotateZ(e.frameCount * .01f);
       
        
        //float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        //frameCount = (int) lerp(frameCount, boxSize, 0.2f);       
        for (int xo = -OFF_MAX; xo <= OFF_MAX; xo += 50) {
            for (int yo = -OFF_MAX; yo <= OFF_MAX; yo += 50) {
                for (int zo = -OFF_MAX; zo <= OFF_MAX; zo += 50) {
                    e.pushMatrix();
                    e.translate(xo, yo, zo);
                    e.box(frameCount);
                    e.rotateX(e.frameCount * .02f);
                    e.rotateY(e.frameCount * .02f);
                    e.rotateZ(e.frameCount * .02f);
                    e.fill(colorFromOffset(xo), colorFromOffset(yo), colorFromOffset(zo));
                    e.box((float) (20 + (Math.sin(e.frameCount / 20.0)) * 15));
                    e.popMatrix();
          
                }
            }                
        }
    popMatrix();
    }
    

    public void drawWords(CallSet e){
        // Draw words
        pushMatrix();
        for (int i = 0; i < numWords; i++) {
            float angle1 = radians(100);
            e.translate(100, 180);
            e.rotate(angle1);
        
            e.textSize(80);
            e.fill(255);
            e.text(words[i], xPositions[i], yPositions[i]);

            xPositions[i] += xSpeeds[i];
            yPositions[i] += ySpeeds[i];

            if (xPositions[i] > e.width || xPositions[i] < 0) {
                xSpeeds[i] *= -1;
            }
            if (yPositions[i] > e.height || yPositions[i] < 0) {
                ySpeeds[i] *= -1;
            }
        }
        popMatrix();

    }

    //Method to simulate Boxes
    public void boxes(CallSet e){

        
            e.translate(e.random(e.width), e.random(e.height)); 
            e.rotateX(e.frameCount * 0.06f);
            e.rotateY(e.frameCount * 0.06f);
            e.rotateZ(e.frameCount * 0.06f);
            float boxSize = 6 + (e.sin(e.frameCount / 0.07f) * 0.02f);
            float r = e.random(255);
            float g = e.random(255);
            float b = e.random(255);
            e.fill(r, g, b);
            e.box(boxSize);

            e.translate(100, 100, 50);
            boxSize = 2 + (e.sin(e.frameCount / 0.05f) * 0.01f);
            r = e.random(255);
            g = e.random(255);
            b = e.random(255);
            e.fill(r, g, b);
            e.box(boxSize);

            boxSize = 8 + (e.sin(e.frameCount / 0.09f) * 0.05f);
            r = e.random(255);
            g = e.random(255);
            b = e.random(255);
            e.fill(r, g, b);
            e.box(boxSize);

            e.strokeWeight(2); 
            e.box(e.frameCount);
            

            

            
                
            // e.translate(random(width), random(height)); 
            // //e.rotateY(angle);
            // //e.rotateX(angle);
            // e.rotateX(e.frameCount * .06f);
            // e.box((float) (6 + (Math.sin(e.frameCount / 0.07f)) * .02f));
            // e.rotateY(e.frameCount * .06f);
            // e.box((float) (6 + (Math.sin(e.frameCount / 0.07f)) * .02f));
            
            // e.translate(100, 100, 50);
            // e.rotateZ(e.frameCount * .06f);
            // e.box((float) (6 + (Math.sin(e.frameCount / 0.07f)) * .02f));
            
            // // Generate random values for red, green, and blue components
            // // float r = e.random(255);
            // // float g = e.random(255);
            // // float b = e.random(255);
            
            // e.fill(r,g,b);
            // e.box((float) (2 + (Math.sin(e.frameCount / 0.05f)) * .01f));
            
            // e.box((float) (8 + (Math.sin(e.frameCount / 0.09f)) * .05f));
            // e.strokeWeight(2); 
            // e.box(e.frameCount);
       

    }

    // Method to simulate rain
    public void rain(CallSet e) {

       
        e.calculateAverageAmplitude();
        translate(0, e.height);
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

    public void circles(CallSet e){
        float x = random(width);
        float y = random(height);
        for (float ring = 150; ring >= 0; ring -= random(2, 10)) {
            //rotate(angle * 145);
            fill(random(256), random(256), random(256));
            translate(e.width / 6, e.height / 3);
            ellipse(x, y, ring, ring);
          }
    }

    
    // Method to update the line position
    public void update(CallSet e) {
        e.calculateAverageAmplitude();
        y = y + 4;

        if (y > e.height + 10) {
            y = -10;
            x = e.random(e.width); // Start the drop from a random x-position again
        }
    }

    // Method to simulate cloud formation
    public void formCloud(CallSet e) {

        e.translate(e.width / 3, e.height / 4);
        e.calculateAverageAmplitude();
        e.fill(255);
        e.translate(e.width  / 10 , e.height / 20);
        
        for (int i = 0; i < cloudNumber; i++) {
            // Update the x-coordinate of each cloud
            clouds[i].move(cloudSpeed);
            // Draw the cloud at its updated position
            clouds[i].display(e);
        }
        
        // Incrementally draw cloud-like shapes
        for (int i = 0; i < cloudNumber; i++) {

            x = random(e.width);
            y = random(e.height);

            // Update the transparency or size of each cloud shape
            // This could involve gradually increasing opacity, size, or density
            // Draw cloud shape at updated properties
            clouds[i].display(e);
        }
    }



    // Method to draw a cloud shape
    public void cloudObject(float a, float b, float c, float d) {
        calculateAverageAmplitude();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        pushMatrix();
        
        noStroke();
        fill(200);

        ellipse(50 - 20, 100, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(20 + 20, 120, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(10, y - 10, c, d); // Adjusting the y-coordinate to slightly raise the cloud

        ellipse(x - 150, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x + 150, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x, y - 130, c, d); // Adjusting the y-coordinate to slightly raise the cloud

        ellipse(x - 120, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x + 120, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x, y - 110, c, d); // Adjusting the y-coordinate to slightly raise the cloud

        ellipse(x - 220, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x + 220, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x, y - 210, c, d); // Adjusting the y-coordinate to slightly raise the cloud

        ellipse(x - 10, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x + 10, y, c, d); // Adjusting the x-coordinate to center the cloud
        ellipse(x, y - 50, c, d); // Adjusting the y-coordinate to slightly raise the cloud
        popMatrix();
    } 

   
    // Inner class to represent a cloud
    class Cloud {
        float x, y; // Position of the cloud
        float radius; // Size of the cloud
        float a, b; // Shape parameters for the cloud
        int cloudColor; // Color of the cloud

        Cloud(float x, float y, float radius, float a, float b, int cloudColor) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.a = a;
            this.b = b;
            this.cloudColor = cloudColor; // Assign color to the cloud
        }

        // Method to move the cloud
        void move(float cloudSpeed) {
           
            x += cloudSpeed; // Move the cloud horizontally
            if (x > width + radius) {
                x = -radius;
                y = random(height);
            }
        }

    

        // Method to display the cloud
        void display(CallSet e) {
            //fill(cloudColor);

            e.pushMatrix();
            e.translate(x,y);

            noStroke();
            e.calculateAverageAmplitude();
            ellipse(x - 20, y, a, b);
            ellipse(x + 20, y, a, b);
            ellipse(x, y - 10, a, b);
            
            e.noStroke();
            e.popMatrix();
        }
    }
    

    int colorFromOffset(int offset) {
        return (int) ((offset + OFF_MAX) / (2.0 * OFF_MAX) * 255);
        }

    }






    //background(0);
            // lights();
            
            // noStroke();
            // pushMatrix();
            // translate(130, height/2, 0);
            // rotateY(1.25f);
            // rotateX(-0.4f);
            // box(100);
            // popMatrix();
            
            // noFill();
            // stroke(255);
            // pushMatrix();
            // translate(500, height*0.35f, -200);
            // sphere(280);
            // popMatrix();
            
            
            // pushMatrix();
            // spiralShape(e);
            // popMatrix();
    
            //code for setting image timers
           //fill(200); // Set fill color to light gray
            // Check if it's time to switch to the next image
            // if (e.frameCount % frameCountThreshold == 0) {
            //     // Increment the current image index
            //     currentImageIndex++;
            //     // Reset the index if it exceeds the number of images
            //     if (currentImageIndex >= visualElements.length) {
            //         currentImageIndex = 0;
            //     }
            // }





            // Draw the current visual element
            //visualElements[currentImageIndex].draw(e);
    
            

            
            
    




            // pushMatrix();
        //     // Example usage of Word and Follow classes
        //     Word word1 = new Word("LITTLE FLUFFY CLOUDS");
        //     Follow follow1 = new Follow("\n\n\nLIVE LIFE ");
        //     word1.follows.add(follow1);
    
        //     // Draw the word
        //     fill(255);
        //     text(word1.getWord(), 100, 100);
    
        //     // Draw the follows
        //     for (int i = 0; i < word1.follows.size(); i++) {
        //         Follow follow = word1.follows.get(i);
        //         text(follow.getWord(), 100, 120 + i * 20); // Adjust y-position to avoid overlap
        //         //lerp(10,20,5);
        //     }
        // popMatrix();






            