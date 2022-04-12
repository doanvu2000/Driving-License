package com.example.drivinglicense.app.activites

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.example.drivinglicense.R
import com.example.drivinglicense.app.adapter.ActionAdapter
import com.example.drivinglicense.app.entity.ItemAction
import com.example.drivinglicense.component.widgets.recyclerview.RecyclerUtils
import com.example.drivinglicense.databinding.ActivityMainBinding
import com.example.drivinglicense.pref.showDevelopMessage
import com.example.drivinglicense.pref.toastMessage
import java.util.ArrayList

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val actionAdapter by lazy {
        ActionAdapter()
    }

    private lateinit var listAction: MutableList<ItemAction>

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green)))
        initView()
        initData()
        initListener()
    }

    private fun initView() {
        initSlide()
    }

    private fun initSlide() {
        val listSlide =
            arrayListOf(
                R.drawable.exam,
                R.drawable.book,
                R.drawable.star,
                R.drawable.law,
                R.drawable.stop
            )
        for (item in listSlide) {
            val imageView = ImageView(this)
            imageView.setImageResource(item)
            binding.slide.addView(imageView)
        }
        binding.slide.flipInterval = 1500
        binding.slide.isAutoStart = true
        val animationSlideIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        val animationSlideOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)
        binding.slide.inAnimation = animationSlideIn
        binding.slide.outAnimation = animationSlideOut
    }

    private fun initData() {
        RecyclerUtils.setGridManager(this, binding.rcvItem, 3, actionAdapter)
        listAction = ArrayList()
        val item1 = ItemAction(getString(R.string.text_exam), R.drawable.exam)
        val item2 = ItemAction(getString(R.string.text_learning_theory), R.drawable.book)
        val item3 = ItemAction(getString(R.string.text_road_signs), R.drawable.stop)
        val item4 = ItemAction(getString(R.string.text_tips), R.drawable.star)
        val item5 = ItemAction(getString(R.string.text_search_law), R.drawable.law)
        listAction = arrayListOf(item1, item2, item3, item4, item5)
        actionAdapter.addData(listAction)
    }

    private fun initListener() {
        actionAdapter.onCLickItem = {
            toastMessage(this, listAction[it].title)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_setting, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_license_A1 -> {
                toastMessage(this, getString(R.string.text_chose_license_A1))
            }
            R.id.item_license_A2 -> {
                toastMessage(this, getString(R.string.text_chose_license_A2))
            }
        }
        return false
    }
}