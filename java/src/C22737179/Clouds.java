package C22737179;
import ie.tudublin.*;

public class Clouds extends Visual {

    float x,y,z,speed;

    public Clouds(float cloudX, float cloudY,float z,float speed){
        this.x=cloudX;
        this.y=cloudY;
        this.z=z;
        this.speed=speed;


    }

    public void setSize(float newSize) {
        z = newSize;
       
    }


    void display(CallSet e)
    {
        //e.imageMode(CENTER);
        e.image(e.cloudImage,x,y,z,z);
    }

    void move(CallSet e,Clouds[] allClouds){
        x += speed; // Move the cloud towards the left

    // if the cloud moves beyond the right boundary
        if (x > e.width) {
            x = random(0, e.width); // Reset x position to a random position within the screen width
            y = random(e.height); // Reset y position to a random height
        }

        // Check for overlap with other clouds and adjust position 
        for (Clouds otherCloud : allClouds) {
            if (otherCloud != this && dist(x, y, otherCloud.x, otherCloud.y) < (z + otherCloud.z) / 2) {
                // If the cloud overlaps with another cloud, adjust its position to the right of the overlapping cloud
                x = otherCloud.x + otherCloud.z + 220;
               
            }
        }
    }
}

