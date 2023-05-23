package stuffs.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class playah {
    private Clip clip;
    public playah(int i) throws UnsupportedAudioFileException, IOException,LineUnavailableException
{
        String fp;
    if (i == 2) {
        fp = "fast.wav";
    } else {
        fp = "ThemeSong.wav";
    }
    URL resource = playah.class.getResource(fp);
        AudioInputStream stream = AudioSystem.getAudioInputStream(resource);
        clip = AudioSystem.getClip();
        clip.open(stream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void start() {
        clip.start();
    }
    public void spedup() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        String fp = "fast.wav";
        clip.stop();
        URL resource = playah.class.getResource(fp);
        AudioInputStream stream = AudioSystem.getAudioInputStream(resource);
        clip = AudioSystem.getClip();
        clip.open(stream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println("10000 reached");
    }

}

//tiny snippet of SampleAudioPlayer class found on https://www.geeksforgeeks.org/play-audio-file-using-java/
