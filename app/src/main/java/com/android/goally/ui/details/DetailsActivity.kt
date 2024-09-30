package com.android.goally.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.goally.R
import com.android.goally.data.model.api.response.copilot.Routine
import com.android.goally.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val routine = intent.getParcelableExtra<Routine>("routine")
        routine?.let {
            println("Routine Name: ${it.name}")
            binding.tvResponse.text=it.name
        }

    }
}