package ebubekir.tosun.ders10

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ebubekir.tosun.ders10.databinding.ActivityWilkommenBinding

class Wilkommen : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityWilkommenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //xlm den verilerimizi cekiyoruz

        preferences = getSharedPreferences("information", MODE_PRIVATE)
        var registrierterBenutzer2 = preferences.getString("benutzer", "")
        var registrierterPasswort2 = preferences.getString("passwort", "")

        // textView lere kayitli bilgileri aktariyoruz
        binding.wilkommenbenutzername.text = "Benutzer name : " + registrierterBenutzer2.toString()
        binding.wilkommenpasswort.text = "Benutzer passwort : " + registrierterPasswort2.toString()

        //Cikis yap
        binding.buttonausloggen.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)


        }


    }
}