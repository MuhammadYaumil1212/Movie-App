package yaumil.training.movie_app.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import yaumil.training.movie_app.SignInActivity
import yaumil.training.movie_app.databinding.ActivityOnBoardingOneBinding

class OnBoardingOneActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOnBoardingOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //for button
        buttonLanjutkan()
        buttonLewati()
    }

    private fun buttonLanjutkan(){
        binding.btnContinue.setOnClickListener {
            finishAffinity()
            startActivity(Intent(
                this,
                OnBoardingTwoActivity::class.java))
        }
    }

    private fun buttonLewati(){
        binding.btnSkip.setOnClickListener {
            finishAffinity()
            startActivity(Intent(
                this,
                SignInActivity::class.java))
        }
    }
}