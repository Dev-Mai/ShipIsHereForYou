package primary;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music {
	void musicPlay(String filepath) {
//		InputStream music;
//		try {
//			music = new FileInputStream(new File(filepath));
//			AudioStream audio = new AudioStream(music);
//			AudioPlayer.player.start(audio);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error");
//		}

		try {
			File musicPath = new File(filepath);
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				JOptionPane.showMessageDialog(null,  "Press OK to stop playing");
			} else {
				System.out.println("Can't find file");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//			File introMusic = new File("src/musics/introBGM.wav");
		//			AudioInputStream musicPlay = AudioSystem.getAudioInputStream(introMusic);
		//			AudioFormat format = musicPlay.getFormat();
		//			DataLine.Info info = new DataLine.Info(Clip.class,  format);
		//			Clip clip = (Clip)AudioSystem.getLine(info);
		//			clip.open(musicPlay);
		//			clip.start();
		//			Thread.sleep(1000);
		//		} catch(Exception e) {
		//			e.printStackTrace();
		//		}
	}
}
