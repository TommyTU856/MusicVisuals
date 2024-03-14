package C22737179;

import ie.tudublin.*;

public class TommyVisuals extends Visual{

    //this.g = e.getGraphics();
    Lollipop[] lollipops;
    int numLollipops = 25;

    public void setup() {

        lollipops = new Lollipop[numLollipops];
        for(int i = 0; i < numLollipops; i++) {
            lollipops[i] = new Lollipop(i);
            System.out.println(lollipops[i]);
        }
        
    }
    
    public void draw(CallSet e) {
        
        this.g = e.getGraphics();
        background(255);
        translate(w(0.5f), h(0.5f));
        for(int i = 0; i < numLollipops; i++) {
            pushMatrix();
            lollipops[i].display();
            lollipops[i].update(); 
            popMatrix();       
        }
        
        
    }

    public float w(float val) {
        if (val == 0) return width;
        return width * val;
    }
      
    public float h(float val) {
        if (val == 0) return height;
        return height * val;
    }

}