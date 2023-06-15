package com.lucasbelgrano.padelmvvmkt.ui.aboutUsView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasbelgrano.padelmvvmkt.R

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
    }

    /*donde estamos, intente para abrir maps
    * btn.setOnClickListener {
    * val intent = Intent (
    *   Intent.ACTION_VIEW,
    *   Uri.parse("geo:40.49153592841981, -3.4033516319532944")
    * ) }
    * startActivity(intent)
    * */
}