package com.lucasbelgrano.padelmvvmkt.ui.aboutUsView

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityAboutUsBinding

private lateinit var binding: ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMaps.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:40.49153592841981, -3.4033516319532944")
            )
            startActivity(intent)
        }
    }
}