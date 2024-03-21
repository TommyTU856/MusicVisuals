package C22737179;

import ie.tudublin.Visual;

public class ResponsiveShape {

    public ResponsiveShape() {
        
    }

    public void render(CallSet e) {

        e.background(0);

        e.translate(e.width/2, e.height/2, 0);
        e.stroke(255);
        e.rotateX(Visual.PI/2);
        e.rotateZ(-Visual.PI/6);
        e.noFill();

        e.beginShape();
        
        e.vertex(-100, -100, -100);
        e.vertex( 100, -100, -100);
        e.vertex(   0,    0,  100);
        e.endShape();
    }
}
