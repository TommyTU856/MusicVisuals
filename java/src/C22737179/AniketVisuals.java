package C22737179;

import ie.tudublin.*;
import processing.core.PShape;

public class AniketVisuals extends Visual {
    CallSet e;
    PShape c;
    int cloudNum = 16;
    float cloudWidth = 400;
    float cloudHeight = 216;
    float cloudX[] = new float[cloudNum];
    float cloudY[] = new float[cloudNum];
    float brightness = 0;

    public AniketVisuals()
    {
        setPosition();
    }

    public void setPosition()
    {
        for(int i = 0; i < cloudNum; i++)
        {
            if (i < 4)
            {
                cloudX[i] = 100 + ((i % 4) * cloudWidth);
                cloudY[i] = 50;
            }
            else if (i >= 4 && i < 8)
            {
                cloudX[i] = 300 + ((i % 4) * cloudWidth);
                cloudY[i] = 50 + cloudHeight;
            }
            else if (i >= 8 && i < 12)
            {
                cloudX[i] = 100 + ((i % 4) * cloudWidth);
                cloudY[i] = 50 + (2 * cloudHeight);
            }
            else if (i >= 12 && i < 16)
            {
                cloudX[i] = 300 + ((i % 4) * cloudWidth);
                cloudY[i] = 50 + (3 * cloudHeight);
            }
        }
    }

    public void moveCloud()
    {
        for (int i = 0 ; i < cloudNum ; i++) 
        {
            cloudX[i] += 5;

            if(cloudX[i] > 1500)
            {
                cloudX[i] = -200;
            }
        }
    }

    public void changeColour(int frameCount)
    {
        if (frameCount % 60 == 0)
            c.setFill(color(random(255),random(255),random(255)));
    }

    public void changeSize(float amplitude)
    {
        cloudWidth = 56 + (4000 * amplitude);
        cloudHeight = 30 + (2160 * amplitude);
    }

    public void draw(CallSet e) {
        if(e.paused == false)
        {
            if (e.frameCount % 60 == 0)
            {
                brightness += 10;
            }

            if (e.frameCount % 60 == 0 && brightness == 100)
            {
                brightness = 0;
            }
            
            c = e.cloud;
            e.colorMode(HSB, 360, 100, 100);
            e.background(200, 100, brightness);

            e.calculateAverageAmplitude();

            for(int i = 0; i < cloudNum; i++)
            {
                e.shape(c, cloudX[i], cloudY[i], cloudWidth, cloudHeight);
            }
    
            moveCloud();

            changeSize(e.getSmoothedAmplitude());

            changeColour(e.frameCount);
        }
          
    }

}
