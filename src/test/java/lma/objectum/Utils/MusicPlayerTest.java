package lma.objectum.Utils;

import javafx.scene.media.MediaPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {

    private String musicPath;

    @BeforeEach
    void setUp() {
        musicPath = getClass().getResource("/lma/objectum/music/music.mp3").toString();
    }

    @Test
    void playMusicTest1() {
        MusicPlayer.playMusic(musicPath);
        assertEquals(MediaPlayer.Status.PLAYING, MusicPlayer.mediaPlayer.getStatus());
    }

    @Test
    void playMusicTest2() { // Kiem thu file ko ton tai (expected: null hoac ko PLAYING)
        MusicPlayer.playMusic("dumpFile.mp3");
        if (MusicPlayer.mediaPlayer != null) {
            assertNotEquals(MediaPlayer.Status.PLAYING, MusicPlayer.mediaPlayer.getStatus());
        }
    }

    @Test
    void stopMusicTest() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.stopMusic();
        assertEquals(MediaPlayer.Status.STOPPED, MusicPlayer.mediaPlayer.getStatus());
    }

    @Test
    void setVolumeTest1() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.setVolume(-1.0);
        assertEquals(0.0, MusicPlayer.mediaPlayer.getVolume());
    }

    @Test
    void setVolumeTest2() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.setVolume(1.5);
        assertEquals(1.0, MusicPlayer.mediaPlayer.getVolume());
    }

    @Test
    void setVolumeTest3() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.setVolume(0.0);
        assertEquals(0.0, MusicPlayer.mediaPlayer.getVolume());
    }

    @Test
    void setVolumeTest4() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.setVolume(1.0);
        assertEquals(1.0, MusicPlayer.mediaPlayer.getVolume());
    }

    @Test
    void setVolumeTest5() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.setVolume(0.1);
        assertEquals(0.1, MusicPlayer.mediaPlayer.getVolume());
    }

    @Test
    void setVolumeTest6() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.setVolume(0.9);
        assertEquals(0.9, MusicPlayer.mediaPlayer.getVolume());
    }

    @Test
    void setVolumeTest7() {
        MusicPlayer.playMusic(musicPath);
        MusicPlayer.setVolume(0.6);
        assertEquals(0.6, MusicPlayer.mediaPlayer.getVolume());
    }
}