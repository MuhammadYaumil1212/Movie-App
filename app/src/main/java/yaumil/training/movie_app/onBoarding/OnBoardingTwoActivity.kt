package yaumil.training.movie_app.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import yaumil.training.movie_app.R
import yaumil.training.movie_app.SignInActivity
import yaumil.training.movie_app.databinding.ActivityOnBoardingTwoBinding

class OnBoardingTwoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOnBoardingTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Button lanjutkan dan lewati
        buttonLanjutkan()
        buttonLewati()
    }
    private fun buttonLanjutkan(){
        binding.btnContinue.setOnClickListener {
            finishAffinity()
            startActivity(
                Intent(
                this,
                OnBoardingThreeActivity::class.java)
            )
        }

    }
    private fun buttonLewati(){
        binding.btnSkip.setOnClickListener {
            finishAffinity()
            startActivity(
                Intent(
                    this,
                    SignInActivity::class.java)
            )
        }
    }
}