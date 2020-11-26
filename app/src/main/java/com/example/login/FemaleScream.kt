package com.example.login

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FemaleScream : AppCompatActivity() {
    var player: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_female_scream)
    }
    fun play(v: View?) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.female_sound)
            //            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    stopPlayer();
//                }
//            });
        }
        player!!.start()
    }

    fun pause(v: View?) {
        if (player != null) {
            player!!.pause()
        }
    } //    public void stop(View v) {
    //        stopPlayer();
    //    }
    //    private void stopPlayer() {
    //        if (player != null) {
    //            player.release();
    //            player = null;
    //            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
    //        }
    //    }
    //    @Override
    //    protected void onStop() {
    //        super.onStop();
    //        stopPlayer();
    //    }
}
