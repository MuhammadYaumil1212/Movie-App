package yaumil.training.movie_app.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import yaumil.training.movie_app.R
import yaumil.training.movie_app.SignInActivity
import yaumil.training.movie_app.databinding.ActivityOnBoardingThreeBinding

class OnBoardingThreeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOnBoardingThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStarting.setOnClickListener {
            finishAffinity()
            startActivity(
                Intent(
                    this,
                    SignInActivity::class.java)
            )
        }

    }
}