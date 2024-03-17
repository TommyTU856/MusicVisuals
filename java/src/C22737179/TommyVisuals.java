package C22737179;

import ie.tudublin.*;

public class TommyVisuals extends Visual{


    Lollipop[] lollipops;
    int numLollipops = 50;
    float radius = 25;
    int p;

    Intro intro;

    public TommyVisuals() {

        lollipops = new Lollipop[numLollipops];
        for(int i = 0; i < numLollipops; i++) {
            lollipops[i] = new Lollipop(i, radius);
        }

        intro = new Intro();
        
    }
    
    public void draw(CallSet e) {

        this.g = e.getGraphics();
        
        intro.draw(e);
        
        if(e.paused == false) {
            
            colorMode(HSB, 360, 100, 100);
            background(80, 100, 100);

            translate(g.width / 2, g.height / 2);
            for(int i = 0; i < numLollipops; i++) {
                pushMatrix();
                lollipops[i].display(e);
                lollipops[i].update(); 
                popMatrix();       
            }
            p = p + 1;
            println(p);
        }
        
    }

}