package C22737179;

import ie.tudublin.Visual;
import processing.core.PShape;

public class CallSet extends Visual {
    
    public void settings()
    {
        size(1500, 950, P3D);
        
        
        println("CWD: " + System.getProperty("user.dir"));
    }

    int mode = 1;
    boolean paused = true;
    PShape rooster;
    PShape cloud;

    public void keyPressed()
    {
        if (key >= '0' && key <= '5')
        {
		    mode = key - '0';
	    }

        switch (key)
        {
            case ' ':
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
            loadAudio("LittleFluffyClouds.mp3");
        } else if (osName.toLowerCase().contains("mac")) {
            loadAudio("/Users/aaronbaggot/GroupCA/MusicVisuals/data/LittleFluffyClouds.mp3");
        } else {
            System.out.println("Unsupported operating system");
        }

        rooster = loadShape("GS0D6S94RVZNHC4AZDRXMJDLF.obj");
        //getAudioPlayer().setGain(-25);
        cloud = loadShape("cloud1.svg");
    }

    AaronVisuals Aaron = new AaronVisuals();
    AniketVisuals Aniket = new AniketVisuals();
    BasakVisuals Basak = new BasakVisuals();
    TommyVisuals Tommy = new TommyVisuals();
    

    public void draw()
    {
        Tommy.draw(this);
        //Aniket.draw(this);
        //Basak.draw(this);
        //Aaron.draw(this);
    }



}
