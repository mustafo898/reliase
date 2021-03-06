package dark.composer.a4pictures1word.fragments

import android.annotation.SuppressLint
import android.os.Handler
import android.view.View
import dark.composer.a4pictures1word.controller.extensions
import dark.composer.a4pictures1word.databinding.FragmentSplashBinding


@SuppressLint("CustomSplashScreen")
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private var i = 0
    private val handler = Handler()

    // progress barni ishlab turishi uchun
    private fun progress () {
        i = binding.progressBar.progress
        Thread {
            while (i < 100) {
                i += 1
                handler.post {
                    binding.progressBar.progress = i
                }
                try {
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            binding.progressBar.visibility = View.INVISIBLE
            extensions.controller?.startMainFragment(MainFragment())
        }.start()
    }

    override fun onViewCreated() {
        progress()
    }
}