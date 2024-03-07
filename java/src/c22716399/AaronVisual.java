package c22716399;

//import processing.core.PApplet;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.*;
//import example.AudioBandsVisual;
//import example.WaveForm;
//import ie.tudublin.Visual;
//import example.CubeVisual;
//import ie.tudublin.VisualException;

//import ie.tudublin.Visual;

public class AaronVisual extends Visual {
    //WaveForm wf;
    //AudioBandsVisual abv;
    
    int mode = 0;

    Minim minim;
   
    AudioPlayer player1;
    AudioPlayer player2;
    
    public void setup() {
        minim = new Minim(this);
        try {
            player2 = minim.loadFile("MusicVisuals/java/src/C22716399/Little_Fluffy_Clouds.mp3");
            player1 = minim.loadFile("MusicVisuals/java/src/C22716399/Yeke_Yeke.mp3");
        } catch (Exception e) {
            println("Error loading audio files: " + e.getMessage());
            
        }
    }

    /*public void settings() {
        size(800, 800, P3D);
        //lights();

        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN);
    }*/

    public void keyPressed() 
    {
		if (key >= '0' && key <= '6') {
			mode = key - '0';
		}
        
        println(mode);
    }

    public void draw() 
    {
        background(0);
        translate(400, 400);
        fill(255,0,255);
        noStroke();
        sphere(50);

        switch (mode) {
            case 1:
            {
                player1.play();
                background(150,0,55);
                
                fill(255,100,0);
                sphere(80);

                break;
            }

            case 2:
            {
                player1.play();
                background(50, 50, 255);
                   
                break;
            }

            case 3:
            {

            }
        } 
    }    
}

