// package C22737179;

// import ie.tudublin.Visual;
// import ddf.minim.*;

// public class AaronVisuals_2 extends Visual {

//     Minim minim;
//     AudioInput in;
//     float n4;
//     float n6;
//     float depth = 100; // Example value, replace with appropriate value
//     float smoothAmp = 0.5f; // Example value, replace with appropriate value
//     int columns = 100; // Example value, replace with appropriate value
//     float smoothness = 10; // Example value, replace with appropriate value
//     float yoff = 0; // Example value, replace with appropriate value
//     float z = 0; // Example value, replace with appropriate value
//     float zLevel = 0; // Example value, replace with appropriate value
//     float asteroidH = 0; // Example value, replace with appropriate value
//     float sphereCol = 0; // Example value, replace with appropriate value
//     float rotation = 0; // Example value, replace with appropriate value
//     int stateMachine = 0; // Example value, replace with appropriate value
//     int timeOfStart = 0; // Example value, replace with appropriate value
//     float smooth2 = 0; // Example value, replace with appropriate value

//     public AaronVisuals_2() {
//         minim = new Minim(this);
//         in = minim.getLineIn();
//         noCursor();
//         smooth();
//         background(0);
//         frameRate(24);
//     }

//     public void draw(CallSet e) {
//         e.fill(0, 50);
//         e.noStroke();
//         e.rect(0, 0, width, height);
//         e.translate(width / 2, height / 2);

//         // Integrate provided code here
//         // -----------------------------------------------------------------------------------------------------------
//         // This section creates the focal point or "spheres"
//         // which are in the foreground of the animation
//         // -----------------------------------------------------------------------------------------------------------
        
//         // height of terrain in middle
//         float hnew = depth*(0.5f+smoothAmp)*noise((columns/2)/smoothness, ((columns/2)+yoff%1-yoff)/smoothness,z) +zLevel + 200;
//         asteroidH += (hnew-asteroidH)*.1;
        
//         pushMatrix();
        
//         // set the colour of the sphere based on the amplitude of music (from white to black)
//         sphereCol = max(0, min(255,map(smoothAmp, 0.4f, 1, 255,0)));
        
//         e.fill(sphereCol); 
//         // set a white stroke for high amplitudes
//         if (smoothAmp < 0.8)
//             noStroke();
//         else
//             e.stroke(255);
            
//         // main centre sphere
//         // change the number of verteces based on the amplitude - less when smaller and more when bigger
//         e.sphereDetail(round(2 + smoothAmp*10));
//         // set translation and rotation
//         e.translate(width/2,height/2,0);
//         e.rotateX(rotation);
//         // add an extra offset to keep the sphere centred roughly, asteroidH makes it follow the height of the terrain
//         if (rotation <= PI/4)
//             e.translate(0,rotation/PI * 1000,asteroidH);
//         else
//             e.translate(0,(0.5f - rotation/PI) * 1000,asteroidH);
        
//         // rotate the spheres
//         e.rotateX(z*2);
//         e.rotateY(z*6);
//         e.rotateZ(z*10);
//         // sphere size based on amplitude
//         e.sphere(30 + 150*smoothAmp);
        
//         // inverse rotation
//         e.rotateZ(-z*10);
//         e.rotateY(-z*6);
//         e.rotateX(-z*2);
//         // slower rotation for outer sphere
//         e.rotateZ(z);
//         e.rotateY(z);
//         e.rotateX(z);
//         // low detail sphere
//         e.sphereDetail(2);
//         // transparent wireframe
//         e.stroke(255);
//         e.noFill();
//         // set size by amplitude, but more constant than inner sphere
//         e.sphere(200+smoothAmp*50);
        
//         e.popMatrix();
        
//         e.translate(width/2,height/2);
//         e.rotateX(rotation);
        
//         if (stateMachine == 7 && timeOfStart >= 45000) // rotate whole view if in state 7
//             e.rotateZ(2*PI*smooth2);
//         // -----------------------------------------------------------------------------------------------------------
        
//         n4 += 0.008;
//         n6 += 0.04;
//     }
// }
