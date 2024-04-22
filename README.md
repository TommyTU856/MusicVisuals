# Music Visualiser Project

# Group Members
| Name | Student Number |
|-----------|-----------|
|Aaron Baggot | C22716399 |
|Thomas Burke | C22737179 |
|Aniket Bedade | C22737179 |
|Basak Deveci | D22124576 |

# Video Of Our Visualisations
[<img src="Image of Youtube link here" width="600px" target="_blank">](Youtube Link Here "Our group Video")


# Description of the assignment
In this project, our team collaborated to create four unique visualizations using Java Processing, with each section contributed by a different team member. Our chosen song is "Little Fluffy Clouds" by The Orb. The goal was to develop visualizations that respond dynamically to music, adjusting colours, shapes, and sizes based on the amplitude and frequency of the audio. To extract audio data from MP3 files, we utilized the Audio Minim library.

The implementation consists of several classes and components, each serving a specific purpose:

Minim, AudioInput, and FFT: These classes from the Minim library handle audio input and fast Fourier transform (FFT) analysis, allowing us to extract features such as amplitude and frequency from the audio.
Visual Elements: Various visual elements, including shapes, images, and text, are used to create the visualizations. These elements respond to the audio features and change dynamically over time.


# Instructions
Execution: 
Run the main.java file located in the ie\tudublin package to start the project.
Controls and Functionality:
Play/Pause: 
Use the space bar to toggle between pausing and resuming the audio playback.
Visualization Selection: 
Switch between different visualizations by pressing the 6, 7, 8, and 9 keys. Each key corresponds to a specific visualization created by Tommy, Aniket, Basak, and Aaron, respectively.
Reset: Press "r" to reset the song to its beginning.
Automatic Transitions: 
Note that the visualizations automatically transition at specific segments of the song to match the corresponding visuals.

# How it works
Each visualization is encapsulated within its own class, all residing within the same package. The driver file for the project is CallSet.java. In this project, objects were instantiated for each visualization. Utilizing inheritance, methods like "calculateAverageAmplitude" from the Visual class were inherited. Minim was employed to load the audio file "LittleFluffyClouds.mp3" within the setup method. Additionally, assets such as .obj files and .png pictures were loaded.
The code utilizes the Minim library for audio processing. It initializes audio objects such as AudioInput and FFT to analyse the audio input. The draw method continuously updates and renders the visuals based on the audio amplitude and frequency.

'''
 	AaronVisuals Aaron = new AaronVisuals();
    AniketVisuals Aniket = new AniketVisuals();
    BasakVisuals Basak = new BasakVisuals();
    TommyVisuals Tommy = new TommyVisuals();
'''
    
'''
public void keyPressed()
    {
        if (key >= '5' && key <= '9')
        {
		    mode = key - '0';
	    }

        switch (key)
        {
            case '5':
            {
                if (paused)
                {
                    getAudioPlayer().play();
                    paused = false;
                }

                else
                {
                    getAudioPlayer().pause();
                    paused = true;
                }

                break;
            }

            case '1':
            {
                getAudioPlayer().play();
                break;
            }

            case 'r':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                break;
            }
        }
        
    }
	
'''






### Section 1 - Aaron

My section of the project aims to create an immersive audio-visual experience that synchronizes visual elements with the mood, tempo, and structure of the song “Little Fluffy Clouds”. To achieve this, I employ object-oriented programming (OOP) principles in Java, utilizing the Processing library. Through encapsulation, inheritance, polymorphism, and other Java features, I enhance code organization, reusability, and maintainability.

The functionality related to visualizations and audio playback is encapsulated within the CallSet class. Methods like keyPressed() and setup() encapsulate logic for handling user input and initializing program setup.
Variables such as mode, paused, rooster, and cloud are encapsulated within the CallSet class to manage state and resources required for visualization. The CallSet class inherits from the Visual class, facilitating code reusability and organization.The draw() method in CallSet demonstrates polymorphism by invoking the draw() method of different visual components based on the mode variable. Control structures like switch-case and if-else statements handle user input and program flow efficiently.
String manipulation and conditional statements are used to load appropriate audio files based on the detected operating system.

Rain.java
- Encapsulates functionality related to rendering and updating raindrops.Contains an array of 
- Drop objects, encapsulating raindrop properties within the class.
- Utilizes constructors to initialize Drop objects and methods to render and update raindrops.

TimeClock.java
- Encapsulates functionality related to displaying a clock with hour, minute, and second arcs.
- Utilizes constructors to initialize PApplet variables and methods to draw arcs representing clock hands.

- The cloudyShapes method draws clouds. It uses the pushMatrix and popMatrix functions to isolate transformations. The rotate function rotates by a specified angle, adding variation to each cloud's appearance. Inside the loop, each cloud's position is updated using the move function, and its display is updated using the display function.

- The spiralShape method draws a spiral shape. It calculates the colour of the shape based on the audio amplitude using the map function. Inside the loop, the spiralShape function is called multiple times to draw concentric circles forming the spiral.

- The stars method draws stars. Inside the loop, it generates random positions and sizes for the stars using the random function and then calls the drawStar function to draw each star.

- The visualCube method draws cubes on the canvas. Inside nested loops, it translates, rotates, and fills each cube based on its position and orientation. The cube's size is determined by the audio amplitude, and its colour is based on its position.

- The drawWords method draws words on the canvas. Inside the loop, it translates each word's position and rotates it slightly. The text size and colour are set, and the word is drawn using the text function.

- The boxes method simulates the appearance of boxes. Inside the loop, it rotates and fills each box based on its position and orientation. The box's size is determined by the audio amplitude, and its colour is randomly generated.

- The rain method simulates raindrops falling. Inside the loop, it creates and updates instances of the Drop class to represent individual raindrops.

- The circles method draws circles in a spiral pattern. Inside the loop, it translates the origin and rotates the canvas before drawing each circle with varying radius.

- The update method updates the position of a line. It increments the y-coordinate of the line and resets it when it reaches the bottom of the screen.

- The formCloud method simulates the formation of clouds. Inside nested loops, it updates and displays instances of the Cloud class to represent clouds.

- The cloudObject method draws a cloud shape. It uses various parameters to specify the position, size, and colour of the cloud.

- The Cloud class represents a cloud object with properties such as position, size, and colour. It has methods to move and display the cloud.

- The colorFromOffset function calculates the colour value based on the offset parameter. It maps the offset value to a colour value between 0 and 255.



Integration of AaronVisuals Class

- Comprehensive integration of various visual elements, including audio processing, drawing shapes, displaying text, etc.
- Utilizes Minim Audio Processing to analyse audio input.
- Implements diverse visual effects and elements, such as clouds, raindrops, stars, cubes, and spirals.
- Ensures audio-visual synchronization by associating different audio sections with corresponding visual effects.
- Responds to user interaction, enhancing interactivity and engagement.
- Provides an immersive audio-visual experience through the harmonious integration of visual and auditory elements.


By effectively leveraging OOP concepts and Java features, my project delivers a captivating audio-visual experience that reflects the mood, tempo, and structure of the selected song. Encapsulation, inheritance, polymorphism, and other principles facilitate code organization, reusability, and flexibility, enhancing the overall quality and interactivity of the program.
Through this project and research, I've gained invaluable personal learning experiences that extend far beyond the realms of textbooks and lectures. Engaging in hands-on development has been a journey of discovery, where each line of code written and every bug fixed has been a lesson in itself. Collaborating with fellow students has added layers of depth to my learning, as we navigated through challenges together, sharing insights and brainstorming solutions. Learning by doing has been immensely enjoyable, as it allowed me to apply theoretical knowledge in a practical context, reinforcing concepts and sharpening my problem-solving skills. Working alongside peers has fostered a sense of camaraderie and mutual support, transforming the project into a collaborative adventure rather than a solitary endeavour. Overall, this experience has not only enhanced my technical proficiency but also enriched my interpersonal skills and instilled in me a deeper appreciation for the iterative process of learning and growth.

From the fundamental lessons of W3Schools' Online Web Tutorials to the boundless opportunities revealed by ChatGPT, each source enriched my understanding and guided my progress. Immersed in the world of Processing, I found inspiration and comfort within its virtual confines. As I tackled the intricacies of OOP, Java, and Processing, the insights shared by respected lecturer Dr Bryan Duggan acted as a guiding light, illuminating my path forward. With appreciation for these invaluable resources, I embarked on an exploration of theory and application, weaving together knowledge and practice to craft an engaging digital experience.


Bibliography and References

 Chatgpt. Available at: https://chat.openai.com/ (Accessed: 12 April 2024).

 Duggan, B. (2024) ‘OOP, Java, Processing’, https://github.com/skooter500/OOP-2024. https://github.com/skooter500/OOP-2024, (Accessed: 20 February 2024).
 
Learn to code W3Schools Online Web Tutorials. Available at: https://www.w3schools.com/ (Accessed: 18 March 2024).

Welcome to processing! (no date) Processing. Available at: https://processing.org/ (Accessed: 15 March 2024).

![Clock]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/Clock.png" width="300" />

![Cube_1]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/Cube_2.png" width="300" />

![Cube_2]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/Cube_3.png" width="300" />

![Lyrics]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/Lyrics_Floating_Words.png" width="300" />

![Moving_Shape]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/MovingShape.png" width="300" />

![Reacting_Clouds]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/Reacting_Clouds.png" width="300" />

![Colours_Shape]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/ShapeColourChange.png" width="300" />

![Moving_Clouds_and_Stars]
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/Aarons_Images/Stars_Moving_Clouds.png" width="300" />












### Section 2 - Tommy
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis9.png" width="300" /><img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis10.png" width="300" /><img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis1.png" width="300" />
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis2.png" width="300" /><img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis3.png" width="300" />
<img src="https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis7.png" width="300" />












### Section 3 - Basak

![Basak's visual](link to images)















### Section 4 - Aniket

![Aniket's visual](link to images)














# Accomplishments in Our Assignment - What we are most proud of.
Our collaboration on this assignment, centered around a song featuring skies and clouds, was a testament to our teamwork and dedication. Throughout the process, we navigated various challenges, particularly concerning the implementation across different operating systems, Mac and Windows. Despite initial differences in ideas, we effectively coordinated our efforts to synchronize colors, map amplitudes, shape visuals, integrate a clock, and even incorporate a rooster object in OBJ format, all harmonized to the music.

Working closely with our lecturer during labs, we overcame obstacles together and grew in our understanding of advanced concepts. Our regular meetings allowed us to discuss our progress and ensure alignment with our goals. Utilizing tools like Git enhanced our collaboration and will undoubtedly benefit us in future career endeavors and team projects.

The diversity of elements in our project, including cubes, various cloud formations, rain effects, responsive shapes, lollipops, balls, lyrics integration, ellipses, and stars, showcases our comprehensive exploration of visualizations. Our use of inheritance, polymorphism, the PApplet library, and other programming principles reflects the depth of our learning in this module.

Ultimately, seeing the final project come together was immensely rewarding, reaffirming our hard work and dedication as a group. This experience has not only enriched our understanding but also provided us with invaluable lessons and memories to carry forward in our academic and professional journeys.


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

