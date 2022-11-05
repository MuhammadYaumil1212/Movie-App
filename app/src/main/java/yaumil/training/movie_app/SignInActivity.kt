package yaumil.training.movie_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import yaumil.training.movie_app.Model.User
import yaumil.training.movie_app.databinding.ActivitySignInBinding


class SignInActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    private lateinit var database: DatabaseReference
    private lateinit var username : EditText
    private lateinit var password : EditText
    private var doubleBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initialize variables
        database = FirebaseDatabase.getInstance().getReference("User")
        username = binding.usernameTxt
        password = binding.passwordTxt
        //run login function
        binding.btnSignIn.setOnClickListener {
            checkField()
        }
    }
    /*
    * check field terlebih dahulu apabila blank maka beri peringatan
    * */
    private fun checkField(){

        if(username.text.isEmpty()){
            Toast.makeText(this,"username kosong",Toast.LENGTH_SHORT).show()
            return
        }

        if(password.text.isEmpty()){
            Toast.makeText(this,"Password kosong",Toast.LENGTH_SHORT).show()
            return
        }

        login()
    }
    /*
    * Login Logic
    * */
    private fun login(){
        database.child(username.text.toString()).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var valUser = snapshot.getValue(User::class.java)

                if(valUser == null){
                    Toast.makeText(this@SignInActivity,"Akun Tidak Ditemukan!",
                        Toast.LENGTH_SHORT).show()
                    return
                }

                if(valUser.password?.equals(password.text.toString()) == true){
                    startActivity(Intent(this@SignInActivity,HomeActivity::class.java))
                }

                if(valUser.password?.equals(password.text.toString()) == false){
                    Toast.makeText(this@SignInActivity,"Password anda salah!",
                        Toast.LENGTH_SHORT).show()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignInActivity,error.message,Toast.LENGTH_LONG).show()
            }

        })
    }
    /*
    * Tap 2 kali apabila anda ingin keluar dari aplikasi
    * */
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