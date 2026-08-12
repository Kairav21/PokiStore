package com.soo.pokistore

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationView
import com.soo.pokistore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    var order = Order()

    private lateinit var binding: ActivityMainBinding

    // Creating variable to store image view
    // private lateinit var img_pikachu : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //     setContentView(R.layout.activity_main)
        //      ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.imgPikachu.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Pikachu says hi",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imgFrog.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Frog says hi",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imgGrey.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Grey says hi",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imgBonez.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Bonez says hi",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imgBigBug.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Big Bug says hi",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imgGarchomp.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Garchomp says hi",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imgHorse.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Horse says hi",
//                Toast.LENGTH_SHORT).show()
//        }
//
//        binding.imgMusicbird.setOnClickListener {
//            //code for handling the click
//            Toast.makeText(this, "Music Bird says hi",
//                Toast.LENGTH_SHORT).show()
//        }

        // img_pikachu = findViewById(R.id.img_pikachu)


        binding.imgPikachu.setOnClickListener(this)
        binding.imgFrog.setOnClickListener(this)
        binding.imgGrey.setOnClickListener(this)
        binding.imgBonez.setOnClickListener(this)
        binding.imgHorse.setOnClickListener(this)
        binding.imgGarchomp.setOnClickListener(this)
        binding.imgBigBug.setOnClickListener(this)
        binding.imgMusicbird.setOnClickListener(this)

        setSupportActionBar(binding.navToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val toggleOnOff = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.navToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggleOnOff)
        toggleOnOff.syncState()

        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener(this)

        val backCallback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    isEnabled = false;
                    onBackPressedDispatcher.onBackPressed()
                    //re-enables it for next time
                    isEnabled = true;
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, backCallback)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.img_pikachu -> order.productName = "Pika"
            R.id.img_frog -> order.productName = "Frog"
            R.id.img_grey -> order.productName = "Grey"
            R.id.img_bonez -> order.productName = "Bonez"
            R.id.img_big_bug -> order.productName = "Bug"
            R.id.img_garchomp -> order.productName = "Garchomp"
            R.id.img_musicbird -> order.productName = "Music"
            R.id.img_horse -> order.productName = "Horse"
        }
        //Toast showing selected dog
        Toast.makeText(this@MainActivity, "You Ordered " + order.productName, Toast.LENGTH_SHORT)
            .show()

        openIntent(applicationContext, order.productName, OrderDetailsActivity::class.java)
    }

    override fun onNavigationItemSelected(item: MenuItem) : Boolean{
        when(item.itemId){
            R.id.nav_phot -> openIntent(this, "",
                PokeSnaps::class.java)
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }
}