package com.example.prayapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.prayapp.R
import com.example.prayapp.data.PrayData
import com.example.prayapp.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getPrayRequest("baghdad")
        initBottomSheet()
    }

    private fun getPrayRequest(city: String) {

        lifecycleScope.launch {
            TimePrayRepository.getInfoPray(city).onCompletion {  }.catch {
                Toast.makeText(
                    this@MainActivity,
                    "error can't access sorry ",
                    Toast.LENGTH_SHORT
                ).show()
            }.collect { getResultPray(it) }
        }
    }

    fun getResultPray(response: Status<PrayData>) {
        return when (response) {
            is Status.Error -> {
                Toast.makeText(
                    this@MainActivity,
                    "error can't access sorry ",
                    Toast.LENGTH_SHORT
                ).show()
            }
            is Status.Loading -> {
                Toast.makeText(
                    this@MainActivity,
                    "Loading access  ",
                    Toast.LENGTH_SHORT
                ).show()
            }
            is Status.Success -> {
                Toast.makeText(
                    this@MainActivity,
                    "error can't access sorry ",
                    Toast.LENGTH_SHORT
                ).show()
                bindData(response.data)
            }
        }
    }

    private fun bindData(data: PrayData) {
        binding.fajrTime.text=data.results?.datetime?.joinToString { it.times?.fajr.toString() }
        binding.duhrTime.text=data.results?.datetime?.joinToString { it.times?.dhuhr.toString() }
        binding.sunriseTime.text=data.results?.datetime?.joinToString { it.times?.sunrise.toString() }
        binding.asrTime.text=data.results?.datetime?.joinToString { it.times?.asr.toString() }
        binding.maghribTime.text=data.results?.datetime?.joinToString { it.times?.maghrib.toString() }
        binding.ishaTime.text=data.results?.datetime?.joinToString { it.times?.isha.toString() }
    }

    private fun initBottomSheet() {
        BottomSheetBehavior.from(binding.bottomSheetPrayTime).apply {
            peekHeight = 200
            state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

}