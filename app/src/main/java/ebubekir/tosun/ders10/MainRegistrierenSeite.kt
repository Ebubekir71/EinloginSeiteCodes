package ebubekir.tosun.ders10

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ebubekir.tosun.ders10.databinding.ActivityMainBinding
import ebubekir.tosun.ders10.databinding.ActivityMainRegistrierenSeiteBinding

class MainRegistrierenSeite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainRegistrierenSeiteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonspeichern.setOnClickListener {
            var benutzerInformation = binding.registerbenutzername.text.toString()
            var benutzerParola = binding.registerbenutzerpasswort.text.toString()
            var SharedPreferences = this.getSharedPreferences("information", MODE_PRIVATE)
            var editor = SharedPreferences.edit()

            //veri ekleme
            editor.putString("benutzer", "$benutzerInformation").apply()
            editor.putString("passwort", "$benutzerParola").apply()
            Toast.makeText(applicationContext, "Speichern erfolgreich", Toast.LENGTH_LONG).show()
            binding.registerbenutzername.text.clear()
            binding.registerbenutzerpasswort.text.clear()
        }

        binding.buttonzuruck.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}