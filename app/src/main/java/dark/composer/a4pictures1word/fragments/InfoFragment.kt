package dark.composer.a4pictures1word.fragments

import dark.composer.a4pictures1word.controller.extensions
import dark.composer.a4pictures1word.utils.Media
import dark.composer.a4pictures1word.databinding.FragmentInfoBinding

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    override fun onPause() {
        super.onPause()
        Media.media?.pause()

//        stopService(Intent(this, MyService::class.java)) // остановить песню
    }

    // развернули приложение
    override fun onResume() {
        super.onResume()
        Media.media?.resume()
//        startService(Intent(this, MyService::class.java)) // запустить песню
    }

    override fun onViewCreated() {
        binding.btnBackSettings.setOnClickListener {
            extensions.controller?.startMainFragment(MainFragment())
        }
    }
}