package ebubekir.tosun.ders10

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ebubekir.tosun.ders10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences("information", MODE_PRIVATE)

        binding.buttoneinloggen.setOnClickListener {
            var registrierterNutzer = preferences.getString("benutzer", "")
            var registrierterNutzerPasswort = preferences.getString("passwort", "")

            var eingegebenBenutzerName = binding.girisbenutzername.text.toString()
            var eingegebenBenutzerPasswort = binding.girisbenutzerpasswort.text.toString()

            if (registrierterNutzer==eingegebenBenutzerName && registrierterNutzerPasswort==eingegebenBenutzerPasswort){
                intent = Intent(applicationContext, Wilkommen::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Falsche Information", Toast.LENGTH_LONG).show()
            }

        }
        binding.buttonregistrieren.setOnClickListener {
            intent = Intent(applicationContext, MainRegistrierenSeite::class.java)
            startActivity(intent)
        }
    }
}