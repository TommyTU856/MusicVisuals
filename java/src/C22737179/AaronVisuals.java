package C22737179;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ie.tudublin.Visual;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import processing.*;
import processing.core.PGraphics; // Import the PGraphics class



public class AaronVisuals extends Visual {


    

    // Declare variables and objects

    Minim minim;
    AudioInput in;
    FFT fft;

    DrawGrid grid;
    Fade fade;
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
    Drop[] d;
    int cloudNumber = 40;
    Cloud[] clouds;
    float cloudSpeed = 1.5f;
    String[] words = {"Clouds", "World", "Fluffy", "Little", "Cloud", "Everwhere", "Floating", "And", "skies", "always", "little",
     "fluffy", "clouds", "They", "were", "long", "clear","Over the past few years","What were the skies like when you were young?",
     "And, er, when it would rain it would all turn, it, they were beautiful","They went on forever and they, when I, we lived in Arizona"};
    int numWords = words.length;
    float[] xPositions, yPositions;
    float[] xSpeeds, ySpeeds;
    float[] lerpedBuffer;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    int inside = color(204, 102, 0);
    int middle = color(204, 153, 0);
    int outside = color(153, 51, 0);
    float xSpeed = 7;
    float ySpeed = 7;
    //Shape p;
    int cloudColor;
    PShape mountainClouds;
    PImage img; // Declare a variable to hold the background image
    int OFF_MAX = 300;

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


    public void mountainClouds(CallSet e) {
        pushMatrix();    
        shape(e.mountainClouds);
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
        Follow follow = new Follow("followingWord");
 
        word1.follows.add(follow);
          
        getSmoothedAmplitude(); 
        
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
    }

    // Method to simulate rain
    public void rain(CallSet e) {

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

    // Method to show a line
    public void show(CallSet e) {
        float t = map(z, 0, 5, 10, 2);
        e.strokeWeight(t);
        line(x, y, x, y + t * 2);
    }

    // Method to update the line position
    public void update(CallSet e) {
        y = y + 4;

        if (y > e.height + 10) {
            y = -10;
            x = e.random(e.width); // Start the drop from a random x-position again
        }
    }

    // Method to draw a cloud shape
    void cloudObject(float a, float b, float c, float d) {
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

    // Method to draw all visual elements
    public void draw(CallSet e) {

        // Perform FFT analysis
        fft.forward(in.mix);

       
        this.g = e.getGraphics(); // Initialize the "g" variable
        float colorChange = 10;
        mountainClouds(e);

        colorMode(RGB);
        e.background(colorChange += (50 * getSmoothedAmplitude()),0,0);
        shapeColor = color(random(255), random(255), random(255));
        stroke(255);
       //fill(200); // Set fill color to light gray

        //e.background(0);
        e.translate(e.width / 2, e.height / 2, -OFF_MAX);
        e.rotateX(e.frameCount * .01f);
        e.rotateY(e.frameCount * .01f);
        e.rotateZ(e.frameCount * .01f);
        
        for (int xo = -OFF_MAX; xo <= OFF_MAX; xo += 50) {
            for (int yo = -OFF_MAX; yo <= OFF_MAX; yo += 50) {
                for (int zo = -OFF_MAX; zo <= OFF_MAX; zo += 50) {
                    e.pushMatrix();
                    e.translate(xo, yo, zo);
                    e.rotateX(e.frameCount * .02f);
                    e.rotateY(e.frameCount * .02f);
                    e.rotateZ(e.frameCount * .02f);
                    e.fill(colorFromOffset(xo), colorFromOffset(yo), colorFromOffset(zo));
                    e.box((float) (20 + (Math.sin(e.frameCount / 20.0)) * 15));
                    e.popMatrix();
                }
          }
        }


        // pushMatrix();
        // translate(width / 2, height / 2); // Center the text
        // textAlign(100);
        // textSize(34);
        // for (int i = 0; i < lyrics.length; i++) {
        //     for (int j = 0; j < lyrics[i].length; j++) {
        //         String line = lyrics[i][j];
        //         for (int k = 0; k < line.length(); k++) {
        //             char character = line.charAt(k);
        //             text(character, 0, i * 30); // Adjust position and spacing as needed
        //             // Increment the x-coordinate for the next character
        //             translate(textWidth(character), 0);
        //         }
        //         // Move to the next line
        //         translate(-textWidth(line), 30);
        //     }
        // }
        // popMatrix();


        // Draw rain
        pushMatrix();
        rain(e);
        popMatrix();




        pushMatrix();
        // Example usage of Word and Follow classes
        Word word1 = new Word("LITTLE FLUFFY CLOUDS");
        Follow follow1 = new Follow("\n\n\nLIVE LIFE ");
        word1.follows.add(follow1);

        // Draw the word
        fill(255);
        text(word1.getWord(), 100, 100);

        // Draw the follows
        for (int i = 0; i < word1.follows.size(); i++) {
            Follow follow = word1.follows.get(i);
            text(follow.getWord(), 100, 120 + i * 20); // Adjust y-position to avoid overlap
            lerp(10,20,5);
        }
        popMatrix();

        // Draw words
        pushMatrix();
        for (int i = 0; i < numWords; i++) {
            float angle1 = radians(45);
            translate(100, 180);
            rotate(angle1);
            textSize(80);
            fill(255);
            text(words[i], xPositions[i], yPositions[i]);

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

        

        // Draw clouds
        pushMatrix();
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
        e.calculateAverageAmplitude();
        pushMatrix();
        translate(e.width / 5, e.height / 3);
        
        for (int i = 0; i < cloudNumber; i++) {
            // Update the x-coordinate of each cloud
            clouds[i].move(cloudSpeed);
            // Draw the cloud at its updated position
            clouds[i].display(e);
        }
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
            fill(cloudColor);
            noStroke();
            e.calculateAverageAmplitude();
            ellipse(x - 20, y, a, b);
            ellipse(x + 20, y, a, b);
            ellipse(x, y - 10, a, b);
            
            e.noStroke();
        }
    }

    int colorFromOffset(int offset) {
        return (int) ((offset + OFF_MAX) / (2.0 * OFF_MAX) * 255);
        }
}


