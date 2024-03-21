package C22737179;

import ie.tudublin.Visual;

public class ResponsiveShape {

    int vert = 50;

    public ResponsiveShape() {
        
    }

    public void render(CallSet e) {

        //e.background(0);
        //e.translate(e.width / 2, e.height / 2);
        
        for(int i = 0; i < vert; i++) {
            for(int j = 0; j < vert; j++) {
                for(int k = 0; k < vert; k++) {
                    float x = Visual.map(i, 0, vert, -250, 250);
                    float y = Visual.map(j, 0, vert, -400, 400);
                    float z = Visual.map(k, 0, vert, -100, 100);
                    //e.stroke(180, 50, 80);
                    e.point(x, y, z);
                    //e.triangle(x, y, x / 2, y / 2, x / 4, y / 4); 
                }
            }
        }

        /* e.translate(4, 3);
        for(int i = 0; i < vert; i++) {
            for(int j = 0; j < vert; j++) {
                for(int k = 0; k < vert; k++) {
                    float x = Visual.map(i, 0, vert, -400, 400);
                    float y = Visual.map(j, 0, vert, -250, 250);
                    float z = Visual.map(k, 0, vert, -100, 100);
                    e.stroke(10, 50, 80);
                    e.point(x, y, z);
                    //e.triangle(x, y, x / 2, y / 2, x / 4, y / 4); 
                }
            }
        }

        e.translate(-4, -3);
        for(int i = 0; i < vert; i++) {
            for(int j = 0; j < vert; j++) {
                for(int k = 0; k < vert; k++) {
                    float x = Visual.map(i, 0, vert, -400, 400);
                    float y = Visual.map(j, 0, vert, -250, 250);
                    float z = Visual.map(k, 0, vert, -100, 100);
                    e.stroke(0, 0, 50);
                    e.point(x, y, z);
                    //e.triangle(x, y, x / 2, y / 2, x / 4, y / 4); 
                }
            }
        }

        e.translate(-4, 3);
        for(int i = 0; i < vert; i++) {
            for(int j = 0; j < vert; j++) {
                for(int k = 0; k < vert; k++) {
                    float x = Visual.map(i, 0, vert, -250, 250);
                    float y = Visual.map(j, 0, vert, -400, 400);
                    float z = Visual.map(k, 0, vert, -100, 100);
                    e.stroke(0, 0, 50);
                    e.point(x, y, z);
                    //e.triangle(x, y, x / 2, y / 2, x / 4, y / 4); 
                }
            }
        } */
        
    }
}
