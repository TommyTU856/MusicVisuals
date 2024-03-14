package C22737179;

import ie.tudublin.*;

public class AaronVisuals extends Visual 
{
    
    Grid grid;
    TimeClock timeClock;
    Fade fade;

    float angle = 0.5f;
    float offset = 10;
    float scalar = 2;
    float speed = 0.05f;
    
  
    public void draw(CallSet e) 
    {
          this.g = e.getGraphics(); // Initialize the "g" variable
          grid = new Grid(this);
          timeClock = new TimeClock(this);
          fade = new Fade(100, 100, 1000, this);
        

          colorMode(RGB);
          background(300);


          grid.drawGrid(500,-500,width ,height  );
          timeClock.drawTimeClock();
          fade.update();
          fade.display();

          stroke(255);
          fill(255, 255, 0);
          translate(width / 2, height / 2); // Center the shapes
          smooth();
          ellipse(mouseX, mouseY, mouseX, mouseX);
          rotate(angle);
          float centerX = width / 2;
          float centerY = height / 2;
          float x = centerX + (offset + cos(angle) * scalar);
          float y = centerY + (offset - sin(angle) * scalar);

          //float x1 = offset - cos(angle) / scalar;
          //float y1 = offset + sin(angle) * scalar;


          

          int radius = 40;
          float x1 = 110f;
          float y1 = 110f;
          float speed = 0.05f;
          int direction = 1;
          x1 += speed * direction;
          y1 += speed * direction;
          if ((x1 > width-radius) || (x1 < radius)) {
            direction = -direction;  // Flip direction
          }
          if (direction == 1) {
            circle(x1, y1, x); // Face right
          } else {
            circle(x1, y1, x);  // Face left
          } 

          grid.drawGrid(200,150,width, height);
          triangle(x1, y1, x, y, x, y);

          ellipse(250, -250, 100, 100);

          float circleX = x + 10;
          float circleY = y + 10;

          fill(105,0,105);
          ellipse(150, -150, 200, 200);

          fill(105,205,170);
          circle(300, -300, x1);

          ellipse(circleX, - circleY, 250, 250);
          

          float circleX1 = x1;
          float circleY1 = y1;

          fill(205,205,0);
          circle(circleX1, -circleY1, 220); 
          angle += speed;
          scalar += speed;

          translate(-width/3, -height/3); // Move origin to a different location
          fill(20, 255, 20); 
          rect(400, - 400, 150, 150); // Draw a rectangle at the new origin

          angle += speed;
          scalar += speed;
            
      }
}
