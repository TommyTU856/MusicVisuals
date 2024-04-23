package C22737179;
import ie.tudublin.*;
//import java.util.Random;

public class cube2 extends Visual{
    float angle = 0; // Initial rotation angle
    float cul = 1;


    public void draw(CallSet e) {
        e.pushMatrix();
        e.calculateAverageAmplitude();
        Clouds[] clouds = e.getClouds();

        for (Clouds cloud : clouds) {
            cloud.move(e,clouds); // Pass the array of all clouds to check for overlap
            cloud.display(e);
        }
        

      // Update rotation angle
        angle += 0.01;

        // Move to the center of the screen
        e.translate(e.width / 2, e.height / 2, 0);

        // Apply rotation to the big cube
        e.rotateY(angle); // Rotate around the Y-axis
        e.rotateX(angle);// Rotate around the X-axis

        // Draw the big cube
        drawBigCube(e);
        e.popMatrix();
        
    }

    void drawBigCube(CallSet e) {
        
        int bigCubeSize = 200; // Size of the big cube
        int numSmallCubes = 5; // Number of small cubes in each dimension
        int smallCubeSize = bigCubeSize / numSmallCubes; // Size of each small cube
    
       


        // Nested loops to draw the small cubes
        for (int x = 0; x < numSmallCubes; x++) {
            for (int y = 0; y < numSmallCubes; y++) {
                 for (int z = 0; z < numSmallCubes; z++) {
                // Calculate position of each small cube within the big cube
                    float posX = x * (smallCubeSize+30)- bigCubeSize / 2;
                    float posY = y * (smallCubeSize+30) - bigCubeSize / 2;
                    float posZ = z * (smallCubeSize+30) - bigCubeSize / 2;

                // Calculate size of the cube based on music amplitude
                   float cubeSize = smallCubeSize + e.getAmplitude() * 70;
                   //e.stroke(map(z, 0, 255, 0, 360), 255, 255);

               
                if (e.random.nextFloat() < 0.1) { // Adjust size based on amplitude
                    cubeSize += e.getAmplitude() * 100;
                }
                
                // Randomly select cubes to change color
                //e.fill(e.random.nextInt(255), e.random.nextInt(255), e.random.nextInt(255));
                //e.fill(e.random(0, 360), 80, 80);
                e.fill(x*y*z,255,255);
                cul += 10;
                if(e.getAmplitude()>0.1f){
                    e.fill(e.random.nextInt(360), e.random.nextInt(255), e.random.nextInt(360));
                }
                
                // Draw the small cube
                e.pushMatrix(); 
                e.translate(posX, posY, posZ); // Move to the position of the small cube
                
                e.box(cubeSize); // Draw the small cube
                e.popMatrix(); // Restore the previous transformation state
            }
        }
      }
    }

    

    

}

    



