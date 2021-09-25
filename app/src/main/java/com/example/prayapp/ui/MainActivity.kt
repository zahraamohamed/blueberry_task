package com.example.prayapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prayapp.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomSheet()
    }

    private fun initBottomSheet() {
        BottomSheetBehavior.from(binding.bottomSheetPrayTime).apply {
            peekHeight = 200
            state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}