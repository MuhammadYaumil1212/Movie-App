package yaumil.training.movie_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import yaumil.training.movie_app.databinding.ActivitySplashScreenBinding
import yaumil.training.movie_app.onBoarding.OnBoardingOneActivity
import kotlin.concurrent.schedule
import java.util.Timer

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //delay 5 second and go to onboarding one
        goToOnBoardingOne()
    }

    private fun goToOnBoardingOne(){
        Timer().schedule(5000){
            startActivity(Intent(
                this@SplashScreenActivity,
                OnBoardingOneActivity::class.java))
        }
    }
}