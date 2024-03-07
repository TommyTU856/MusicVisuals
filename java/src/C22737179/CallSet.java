package C22737179;

import ie.tudublin.Visual;

public class CallSet extends Visual {
    
    public void settings()
    {
        size(1200, 700, P3D);
        println("CWD: " + System.getProperty("user.dir"));
    }

    int mode = 1;
    boolean paused = true;

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
        
        setFrameSize(1024);
        frameRate(60);

        startMinim();
        loadAudio("LittleFluffyClouds.mp3");

        //getAudioPlayer().setGain(-25);
    }

    AaronVisuals Aaron = new AaronVisuals();
    AniketVisuals Aniket = new AniketVisuals();
    BasakVisuals Basak = new BasakVisuals();
    TommyVisuals Tommy = new TommyVisuals();
    

    public void draw()
    {
        Tommy.render(this);
        //Aniket.render(this);
        //Basak.render(this);
        //Aaron.render(this);
    }



}
