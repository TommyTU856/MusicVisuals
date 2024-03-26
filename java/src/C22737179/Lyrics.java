package C22737179;

public class Lyrics {

    String lyrics = "Over the past few years To the traditional sounds of the English summer The drone of lawnmowers The smack of leather on willow";
    int index = 1; 
    int xPos = 20; 
    int yPos = 50; 
    int typingSpeed = 50; 


    public void render(CallSet e) {

        
        
        e.textSize(20);

        e.background(255);
        e.fill(0);
        e.text(lyrics.substring(0, index), xPos, yPos);
  
  
        if (index < lyrics.length()) {
            index += 1;
            //e.delay(typingSpeed);
        }
    }

}
