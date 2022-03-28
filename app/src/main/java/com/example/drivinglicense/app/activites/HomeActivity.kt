package com.example.drivinglicense.app.activites

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.drivinglicense.R
import com.example.drivinglicense.databinding.ActivityMainBinding
import com.example.drivinglicense.pref.showDevelopMessage
import com.example.drivinglicense.pref.toastMessage

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loadingView.start()
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green)))
//        supportActionBar?.setDisplayShowTitleEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setIcon(R.drawable.ic_settings)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_setting,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_license_A1 ->{
                toastMessage(this,getString(R.string.text_chose_license_A1))
            }
            R.id.item_license_A2 ->{
                toastMessage(this,getString(R.string.text_chose_license_A2))
            }
        }
        return false
    }
}