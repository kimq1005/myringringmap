package com.example.mymap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mymap.databinding.ActivityMain2Binding
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity() {
    private var main2Binding: ActivityMain2Binding? = null
    private val binding get() = main2Binding!!

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main2Binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout: DrawerLayout = binding.drawerlayout
        val navView: NavigationView = binding.navView

        binding.menu.setOnClickListener {

            binding.drawerlayout.openDrawer((GravityCompat.END))

        }


        binding.mainNavigationBtn1.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "1이다",
                Toast.LENGTH_SHORT
            ).show()
        }


        binding.mainNavigationBtn2.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "2다",
                Toast.LENGTH_SHORT
            ).show()
        }



        binding.mainNavigationBtn3.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "3이다",
                Toast.LENGTH_SHORT
            ).show()
        }
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_message -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_sync -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_trash -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.item_setting -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_login -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_share -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_rate_us -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()

            }

            true
        }

//        val headerview = navView.getHeaderView(0)
//        val username = headerview.findViewById<TextView>(R.id.user_name)
//        username.setOnClickListener {
//            Toast.makeText(applicationContext, "유저클릭뭰", Toast.LENGTH_SHORT).show()
//
//        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)

        if (toggle.onOptionsItemSelected(item)) {

            return true
        }
    }


}