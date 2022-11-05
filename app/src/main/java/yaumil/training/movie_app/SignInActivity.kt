package yaumil.training.movie_app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import yaumil.training.movie_app.databinding.ActivitySignInBinding


class SignInActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    private var doubleBack = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //run login function
        login()
    }

    private fun login(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        myRef.setValue("Hello, World!")
        Toast.makeText(this,"Data saved to database",Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        if(doubleBack){
            super.onBackPressed()
            return
        }
        this.doubleBack = true
        Toast.makeText(this,"Tap 2x untuk keluar",Toast.LENGTH_LONG).show()
        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBack = false },2000)
    }

}