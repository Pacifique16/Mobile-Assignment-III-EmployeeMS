package com.auca.employeemanagement;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicPlayerService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        // Create a simple tone generator as background music
        // In a real app, you would use: mediaPlayer = MediaPlayer.create(this, R.raw.your_music_file);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Background Music Service Started", Toast.LENGTH_SHORT).show();
        
        try {
            if (!mediaPlayer.isPlaying()) {
                // In production, you'd load an actual audio file
                // mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Background Music Service Stopped", Toast.LENGTH_SHORT).show();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
