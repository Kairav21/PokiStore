package com.soo.pokistore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.soo.pokistore.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    var order = Order()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_order_details)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get the name of the ordered product from the intent
        order.productName = intent.getStringExtra("order").toString()

        //set the product name on the text view
        binding.tvYouOrdered.text = order.productName

        when(order.productName)
        {
            "Pikachu" -> binding.imgOrderedPokemon.setImageResource(R.drawable.pikachu)
            "BigBug" -> binding.imgOrderedPokemon.setImageResource(R.drawable.bigbug)
            "Bonez" -> binding.imgOrderedPokemon.setImageResource(R.drawable.bonez)
            "Frog" -> binding.imgOrderedPokemon.setImageResource(R.drawable.frog)
            "Garchomp" -> binding.imgOrderedPokemon.setImageResource(R.drawable.garchomp)
            "Grey" -> binding.imgOrderedPokemon.setImageResource(R.drawable.grey)
            "Horse" -> binding.imgOrderedPokemon.setImageResource(R.drawable.horse)
            "MusicBird" -> binding.imgOrderedPokemon.setImageResource(R.drawable.musicbird)
        }

        binding.fabOrder.setOnClickListener()
        {
            shareIntent(applicationContext, order.productName)
        }
    }
}