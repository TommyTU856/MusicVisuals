package C22737179;

import ie.tudublin.*;

public class BasakVisuals extends Visual {

    
    float x=100*2+100;
    float y=100*2+50;
    float angle;
    int value=300;
    Ellipse ellipse;
    CandleSticks candleSticks;
    

    
    

    public BasakVisuals() {
        this.ellipse=new Ellipse(x ,y, angle, value);
        this.candleSticks=new CandleSticks();
    }

    
    
    public void draw(CallSet e) {
       
        this.g = e.getGraphics();
        background(0);
        translate(g.width/2,g.height/2);

        colorMode(HSB);
        //candleSticks.draw(e);

        ellipse.draw(e);
        
        
    }

}

    



