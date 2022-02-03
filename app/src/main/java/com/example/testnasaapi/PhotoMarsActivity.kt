package com.example.testnasaapi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.testnasaapi.api.config.controllers.NasaServiceImpl
import com.example.testnasaapi.databinding.ActivityPhotoMarsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PhotoMarsActivity : AppCompatActivity() {

    lateinit var binding: ActivityPhotoMarsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoMarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            val nasaRequestPhotoMars = NasaServiceImpl().getNasaPhotoMars()

            try {
                launch(Dispatchers.Main) {
                    if (nasaRequestPhotoMars.second == null) {
                        nasaRequestPhotoMars.first?.let {
                            binding.run {

                                val a = it.photos?.firstOrNull()?.img_src

                                Glide.with(this@PhotoMarsActivity)
                                    .load(a)
                                    .circleCrop()
                                    .into(mainIV)

                                textView2.text = it.photos?.firstOrNull()?.id.toString()



//                                mainTV.text = it.explanation
//                                titleTV.text = it.title
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