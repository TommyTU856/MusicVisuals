package C22737179;
import ie.tudublin.*;
//import java.util.Random;

public class RandomizedCubePattern extends Visual {
    int numCubes = 50; // Number of cubes
    float[][] cubePositions = new float[numCubes][3]; // Array to store cube positions (x, y, z)
    float[] cubeSizes = new float[numCubes]; // Array to store cube sizes

    public void setup() {
        // Set up the canvas
        //size(800, 600, P3D);

        // Generate random cube positions and sizes
        
        
    }
    int frameDelay = 1000; // Delay in frames (adjust as needed)
    int lastFrame = 0; 

    public void draw(CallSet e) {
        // Clear the background
        

        // Draw the cubes
        drawCubes(e);
        
        generateRandomCubePattern(e);
    }

    void generateRandomCubePattern(CallSet e) {
        // Generate random positions and sizes for each cube
        for (int i = 0; i < numCubes; i++) {
            float x = e.random(e.width);
            float y = e.random(e.height);
            float z =e. random(-200, 200); // Randomize the z-coordinate for 3D effect
            float size = e.random(20, 100); // Randomize the size of the cube
            cubePositions[i] = new float[]{x, y, z};
            cubeSizes[i] = size;
        }
    }

    void drawCubes(CallSet e) {
        // Draw each cube based on the generated positions and sizes
        for (int i = 0; i < numCubes; i++) {
            float[] pos = cubePositions[i];
            float size = cubeSizes[i];
            e.pushMatrix();
            e.translate(pos[0], pos[1], pos[2]);
            e.fill(e.random(255), e.random(255), e.random(255)); // Randomize the color of each cube
            e.box(size);
            e.popMatrix();
        }
    }
}
