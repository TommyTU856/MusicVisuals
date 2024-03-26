package C22737179;

import ie.tudublin.*;
import processing.core.PShape;

public class AniketVisuals extends Visual {

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
        c = e.cloud;
        e.colorMode(HSB, 360, 100, 100);
        e.background(360);

        if(e.frameCount % 60 == 0)
        {
            changeColour();
            
            if(cloudWidth == 560 && cloudHeight == 300)
            {
                decreaseSize();
            }
            else
            {
                increaseSize();
            }
        }

        for(int i = 0; i < cloudNum; i++)
        {
            e.shape(c, cloudX[i], cloudY[i], cloudWidth, cloudHeight);
        }
  
        moveCloud();
    }

}
