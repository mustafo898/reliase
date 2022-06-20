package dark.composer.a4pictures1word.utils

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.Nullable
import dark.composer.a4pictures1word.R


class MyService : Service() {
    var mediaPlayer: MediaPlayer? = null

    @Nullable
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.gamemusic)
        mediaPlayer!!.isLooping = true // Set looping
        mediaPlayer!!.setVolume(100f, 100f)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mediaPlayer!!.start()
        return startId
    }

    @Deprecated("Deprecated in Java")
    override fun onStart(intent: Intent, startId: Int) {

    }

    override fun onDestroy() {
        mediaPlayer!!.stop()
        mediaPlayer!!.release()
    }

    override fun onLowMemory() {}
}