package com.example.testnasaapi

import android.content.Intent
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

        val nextIntent = Intent(this, PhotoMarsActivity::class.java)

        requestNasaApi()

        binding.NextB.setOnClickListener {
            startActivity(nextIntent)
        }

    }

    private fun requestNasaApi() {
        GlobalScope.launch {
            val nasaRequestApod = NasaServiceImpl().getNasaPlanetaryApod()

            try {
                launch(Dispatchers.Main) {
                    if (nasaRequestApod.second == null) {
                        nasaRequestApod.first?.let {
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

        GlobalScope.launch {
            val nasaRequestEarth = NasaServiceImpl().getNasaPlanetaryEarth()

            try {
                launch(Dispatchers.Main) {
                    if (nasaRequestEarth.second == null) {
                        nasaRequestEarth.first?.let {
                            binding.run {
                                // не приходит картинка ( может быть потому что проблема в кортинке )
                                Glide.with(this@MainActivity)
                                    .load(it.url)
                                    .into(earthIV)

                                datatestTV.text = it.date
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("errorNasa", "Earth", e)
            }
        }
    }

}