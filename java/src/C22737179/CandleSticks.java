package C22737179;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.*;

public class CandleSticks extends Visual{

    AudioBuffer b;
    float y = 400;

    float lerpedAvg = 0;
    Minim m;
    AudioInput ai;
    AudioPlayer ap;


    public void setup(CallSet e) {
        // Setup code goes here
        m = new Minim(this);
        //ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ap = m.loadFile("heroplanet.mp3");
        ap.play();
        b = ap.mix;
    }

    public void draw(CallSet e){

        e.calculateAverageAmplitude();
        float h=height/2;
        for(int i =0; i<b.size(); i++)
        {
            //e.pushMatrix();
            //e.lights();
            
            float hue =map(i,0,b.size(),0,256);
            e.stroke(hue,255,255);
            noFill();
            

            //line(i,400,i,200);


        }
        
            float tot = 0;
            for(int i = 0 ; i < b.size() ; i ++)
            {
                tot += abs(b.get(i));
            }

            float avg = tot / b.size();

            lerpedAvg = lerp(lerpedAvg, avg, 0.1f);
            
            e.stroke(250, 255, 255);
            e.circle(h, h, avg * h * 5);

            e.stroke(200, 255, 255);
            e.circle(h * 0.5f, h, lerpedAvg * h * 5);

            e.circle(h, y, 50);
            y += random(-10, 10);

            lerped = lerp(lerped, y, 0.1f);

            e.stroke(100, 255, 255);
            e.circle(h + 200, lerped, 50);




            // Drawing code goes here
        }

        float lerped = 0;
                //e.noFill();
                //circle(i, i, i);
                //e.stroke(map(i, 0, 360, 0, 255), 255, 255);
                //e.line(width/2,height/2,width,height);

                //calculateAverageAmplitude();
            
        
    
            

 }

    




