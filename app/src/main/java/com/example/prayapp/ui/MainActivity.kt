package com.example.prayapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.prayapp.R
import com.example.prayapp.data.PrayData
import com.example.prayapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getPrayRequest("baghdad")
    }

    private fun getPrayRequest(city:String) {
        lifecycleScope.launch {
        TimePrayRepository.getInfoPray(city).collect { getResultPray(it) }
        }
    }

    fun getResultPray(response :Status<PrayData> ){
        return when(response){
            is Status.Error -> {
                Toast.makeText(this@MainActivity,
                    "error can't access sorry ",
                    Toast.LENGTH_SHORT).show()
            }
            is Status.Loading -> {
                Toast.makeText(this@MainActivity,
                    "Loading access  ",
                    Toast.LENGTH_SHORT).show()
            }
            is Status.Success -> {
                Toast.makeText(this@MainActivity,
                    "error can't access sorry ",
                    Toast.LENGTH_SHORT).show()

            }



        }
    }
}