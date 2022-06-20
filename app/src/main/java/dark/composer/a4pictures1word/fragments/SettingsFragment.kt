package dark.composer.a4pictures1word.fragments

import dark.composer.a4pictures1word.controller.extensions
import dark.composer.a4pictures1word.shared.Shared
import dark.composer.a4pictures1word.utils.Media
import dark.composer.a4pictures1word.databinding.FragmentSettingsBinding


class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {
    private val shared by lazy {
        Shared(requireContext())
    }

    override fun onViewCreated() {
        binding.btnBackSettings.setOnClickListener {
            extensions.controller?.startMainFragment(MainFragment())
        }

        binding.mute.isChecked = shared.getSwitch()

        var d = false

        binding.mute.setOnClickListener {
            if (!d){
                d = true
                Media.media?.resume()
                binding.mute.isChecked = d
                shared.setSwitch(d)
//                startService(Intent(this, MyService::class.java)) // запустить песню
            }else{
                d = false
                shared.setSwitch(d)
                Media.media?.pause()
                binding.mute.isChecked = d
//                stopService(Intent(this, MyService::class.java)) // остановить песню
            }
        }
    }
}