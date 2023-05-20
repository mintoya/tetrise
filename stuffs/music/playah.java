package stuffs.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class playah { private Clip clip;
    public playah(int i) throws UnsupportedAudioFileException, IOException,LineUnavailableException
{
        String fp;
        switch (i){
            case(1)->{fp = "stuffs/music/really slow.wav";}
            case(3)->{fp = "stuffs/music/fast.wav";}
            default -> {fp = "stuffs/music/ThemeSong.wav";}
        }
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File(fp).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(stream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void start() {
        clip.start();
    }

}

//tiny snippet of SampleAudioPlayer class found on https://www.geeksforgeeks.org/play-audio-file-using-java/
