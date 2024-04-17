package C22737179;


import ie.tudublin.*;
import processing.core.PApplet;
import ddf.minim.*;

public class AaronVisuals_2 extends Visual {

    int sphereRadius;
    float spherePrevX;
    float spherePrevY;
    int yOffset;
    boolean initialStatic = true;
    float[] extendingSphereLinesRadius;
    int OFF_MAX = 300;

    public AaronVisuals_2() {
        
    }

    public void draw(CallSet e) {
        
        e.background(0);
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
      }
      
      int colorFromOffset(int offset) {
        return (int) ((offset + OFF_MAX) / (2.0 * OFF_MAX) * 255);
      }
    }
