package com.tech.baptista.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tech.baptista.colormyviews.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val colorList = listOf(Color.BLACK, Color.WHITE, Color.GRAY)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            val clicableViews: List<View> =
                listOf(
                    boxOneText, boxTwoText, boxThreeText, boxFourText,
                    boxFiveText, boxSixText,  boxSevenText,
                    redButton, yellowButton, greenButton,
                    constraintLayout
                )
            for (item in clicableViews) {
                item.setOnClickListener {
                    makeColored(it)
                }
            }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color constant from the Color class for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_six_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_seven_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Buttons using custom color defined in color.xml for background
            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.green_button ->{
                binding.boxFourText.setBackgroundResource(R.color.my_green)
                binding.boxSixText.setBackgroundResource(R.color.my_green)
            }
            R.id.yellow_button -> {
                binding.boxFiveText.setBackgroundResource(R.color.my_yellow)
                binding.boxSevenText.setBackgroundResource(R.color.my_yellow)
            }

            // Boxes using custom color defined in color.xml for background
            else -> view.setBackgroundColor(colorList[(0..2).random()])
        }
    }
}