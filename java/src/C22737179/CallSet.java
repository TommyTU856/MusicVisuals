package C22737179;

import ie.tudublin.Visual;
import processing.core.PShape;
import processing.core.PImage;
import java.util.Random;


public class CallSet extends Visual {
    
    public void settings()
    {
        size(1500, 950, P3D);
        
        //fullScreen(1);
        
        println("CWD: " + System.getProperty("user.dir"));
    }
    
    int mode = 1;
    boolean paused = true;
    PShape rooster;
    PShape cloud;
    PShape mountainClouds;
    PImage backgroundImage;
    PImage img;
    Random random;
    PImage cloudImage;
    PImage blackClouds;

    Clouds[] clouds;
   
    

    public void keyPressed()
    {
        if (key >= '5' && key <= '9')
        {
		    mode = key - '0';
	    }

        switch (key)
        {
            case '5':
            {
                if (paused)
                {
                    getAudioPlayer().play();
                    paused = false;
                }

                else
                {
                    getAudioPlayer().pause();
                    paused = true;
                }

                break;
            }

            case '1':
            {
                getAudioPlayer().play();
                break;
            }

            case 'r':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                break;
            }
        }
        
    }

    public void setup()
    {
        
        colorMode(HSB);
        // noCursor();
        windowMove(0, 0);
        setFrameSize(1024);
        frameRate(60);
        startMinim();
        /* loadAudio("LittleFluffyClouds.mp3");
        loadAudio("/Users/aaronbaggot/GroupCA/MusicVisuals/data/LittleFluffyClouds.mp3"); */

        String osName = System.getProperty("os.name");

        if (osName.toLowerCase().contains("win")) {
            //loadAudio("heroplanet.mp3");
            loadAudio("LittleFluffyClouds.mp3");
        } else if (osName.toLowerCase().contains("mac")) {
            loadAudio("/Users/aaronbaggot/GroupCA/MusicVisuals/data/LittleFluffyClouds.mp3");
        } else {
            System.out.println("Unsupported operating system");
        }

        rooster = loadShape("GS0D6S94RVZNHC4AZDRXMJDLF.obj");
        backgroundImage = loadImage("skyy.jpg");
        //img = loadImage("data/feature_clouds.jpg");
        random=new Random();
        cloudImage = loadImage("asd.jpg");
        blackClouds = loadImage("java/data/BlackClouds.jpg");
g


        //clouds

        clouds = new Clouds[50];
        for (int i = 0; i < clouds.length; i++) {
            // Initialize clouds with random parameters
            clouds[i] = new Clouds(random(width), random(height), random(300, 400),3);
            clouds[i].setSize(370);
        }
        
        

      

      
        //getAudioPlayer().setGain(-25);
        cloud = loadShape("cloud1.svg");
       
        
    }

    public Clouds[] getClouds() {
        return clouds;
    }

   

    AaronVisuals Aaron = new AaronVisuals();
    AniketVisuals Aniket = new AniketVisuals();
    BasakVisuals Basak = new BasakVisuals();
    TommyVisuals Tommy = new TommyVisuals();
    
    

    public void draw()
    {
        //Tommy.draw(this);
        //Aniket.draw(this);
        //Basak.draw(this);
        //Aaron.draw(this);

        switch (mode) {

            case 5:
            {
                Tommy.draw(this);
                break;
            }
            
            case 6:
            {
                Aniket.draw(this);
                break;
            }

            case 7:
            {
                Basak.draw(this);
                break;
            }

            case 8:
            {
                Aaron.draw(this);
                break;
            }

            case 9:
            {
                Tommy.draw(this);
                break;
            }

            default:
                break;
        }
        
    }

    public void creativeTwirl(int i, float f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creativeTwirl'");
    }

    public float random(double d, double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'random'");
    }

}
