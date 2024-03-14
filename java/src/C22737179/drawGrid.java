package C22737179;

import processing.core.PApplet;

class Grid {

    PApplet pa; // Declare a PApplet variable

    public Grid(PApplet pa) {
        this.pa = pa;
    }
        

    public void drawGrid(int x, int y, int width, int height) {

        for (int gridY = 0; gridY < pa.height; gridY += pa.height / 10){
            for (int gridX = 0; gridX < pa.width; gridX += pa.width / 10){
              pa.line(gridX, gridY, gridX + pa.width / 10, gridY + pa.height / 10);
              pa.line(gridX+pa.width / 10, gridY, gridX, gridY + pa.height / 10);
            }
        
        }
    }
}