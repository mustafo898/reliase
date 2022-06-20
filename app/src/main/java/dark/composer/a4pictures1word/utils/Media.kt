package dark.composer.a4pictures1word.utils

import android.content.Context
import android.media.MediaPlayer
import android.support.annotation.RawRes

class Media private constructor(){

    private var mMediaPlayer: MediaPlayer? = null

    companion object {
        var media: Media? = null
        fun getInstance() {
            if (media == null) {
                media = Media()
            }
        }
    }

    fun play(context: Context, @RawRes raw: Int) {
        mMediaPlayer = MediaPlayer.create(context, raw)
        mMediaPlayer?.isLooping = true
        mMediaPlayer?.start()
    }

    fun start(){
        mMediaPlayer?.start()
    }

    fun pause(){
        mMediaPlayer?.pause()
    }

    fun resume(){
        mMediaPlayer?.reset()
    }

}