package stuffs.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class playah { private Clip clip;
    public playah(int i) throws UnsupportedAudioFileException, IOException,LineUnavailableException
{
        String fp;
        switch (i){
            case(1)->{fp = "really slow.wav";}
            case(3)->{fp = "fast.wav";}
            default -> {fp = "ThemeSong.wav";}
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

}

//tiny snippet of SampleAudioPlayer class found on https://www.geeksforgeeks.org/play-audio-file-using-java/
