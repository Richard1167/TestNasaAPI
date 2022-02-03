package com.example.testnasaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.testnasaapi.api.config.controllers.NasaServiceImpl
import com.example.testnasaapi.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            val nasaRequest = NasaServiceImpl().getNasaPlanetaryApod()

            try {
                launch(Dispatchers.Main) {
                    if (nasaRequest.second == null) {
                        nasaRequest.first?.let {
                            binding.run {

                                Glide.with(this@MainActivity)
                                    .load(it.url)
                                    .into(mainIV)

                                mainTV.text = it.explanation
                                titleTV.text = it.title
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("errorNasa", "nassa", e)
            }
        }
    }

}