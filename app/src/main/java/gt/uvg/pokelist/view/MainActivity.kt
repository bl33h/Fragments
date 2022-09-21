package gt.uvg.pokelist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: actBinding
    private lateinit var navController: NavController

    /* Activity binding method + fragment manager */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = actBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }
}