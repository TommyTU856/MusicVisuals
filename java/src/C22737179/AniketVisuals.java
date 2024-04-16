package C22737179;

import ie.tudublin.*;
import processing.core.PShape;

public class AniketVisuals extends Visual {
    CallSet e;
    PShape c;
    int cloudNum = 4;
    float cloudWidth = 560;
    float cloudHeight = 300;
    float cloudX[] = new float[cloudNum];
    float cloudY[] = new float[cloudNum];

    public AniketVisuals()
    {
        randomisePosition();
    }

    public void randomisePosition()
    {
        for(int i = 0; i < cloudNum; i++)
        {
            cloudX[i] = random(100, 1000);
            cloudY[i] = random(50, 600);
        }
    }

    public void moveCloud()
    {
        for (int i = 0 ; i < cloudNum ; i++) 
        {
            cloudX[i] += 5;

            if(cloudX[i] > 1500)
            {
                cloudX[i] = -cloudWidth;
            }
        }
    }

    public void changeColour()
    {
        c.setFill(color(random(360), random(100), random(100)));
    }

    public void decreaseSize()
    {
        cloudWidth += 56;
        cloudHeight += 30;
    }

    public void increaseSize()
    {
        cloudWidth -= 56;
        cloudHeight -= 30;
    }

    public void draw(CallSet e) {
        if(e.paused == false)
        {
            c = e.cloud;
            e.colorMode(HSB, 360, 100, 100);
            e.background(0, 0, 0);

            e.calculateAverageAmplitude();
            
            if(e.getAudioPlayer().left.level() > 0.14 && e.frameCount % 60 == 0)
            {
                // value printed is the RMS (root mean square)
                println(e.getAudioPlayer().left.level());

                if(cloudWidth == 560 && cloudHeight == 300)
                {
                    decreaseSize();
                }
                else
                {
                    increaseSize();
                }
            }

            if(e.getAudioPlayer().left.level() > 0.16)
            {
                changeColour();
            }

            for(int i = 0; i < cloudNum; i++)
            {
                e.shape(c, cloudX[i], cloudY[i], cloudWidth, cloudHeight);
            }
    
            moveCloud();
        }
          
    }

}
