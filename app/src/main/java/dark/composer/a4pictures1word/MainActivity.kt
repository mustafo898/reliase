package dark.composer.a4pictures1word

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dark.composer.a4pictures1word.controller.extensions
import dark.composer.a4pictures1word.databinding.ActivityFragmentBinding
import dark.composer.a4pictures1word.fragments.SplashFragment

class MainActivity : AppCompatActivity(){
    lateinit var binding : ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extensions.init(R.id.container,supportFragmentManager)
        extensions.controller?.startMainFragment(SplashFragment())
    }
}