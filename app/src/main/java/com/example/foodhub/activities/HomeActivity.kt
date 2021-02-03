package com.example.foodhub.activities

import android.os.Bundle
import android.system.Os.close
import android.system.Os.open
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.foodhub.R
import com.example.foodhub.databinding.ActivityHomeBinding
import com.example.foodhub.fragments.fragmentsHome.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    lateinit var acercaFragment: AcercaFragment
    lateinit var configFragment: ConfigFragment
    lateinit var homeFragment: HomeFragment
    lateinit var politicaFragment: PoliticaFragment
    lateinit var salirFragment: SalirFragment
    lateinit var userFragment: UserFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
       setContentView(binding.root)

        acercaFragment = AcercaFragment()
        configFragment = ConfigFragment()
        homeFragment = HomeFragment()
        politicaFragment = PoliticaFragment()
        salirFragment = SalirFragment()
        userFragment = UserFragment()



        openFragment(homeFragment)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        //Creando el toogle del Drawer
        val toolbar = binding.incluyedLayout.toolbar

        setSupportActionBar(toolbar)
        var actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            (((R.string.open))),
            ((R.string.close))
        ) {
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                homeFragment = HomeFragment()
                openFragment(homeFragment)
            }
            R.id.nav_perfil -> {
                userFragment = UserFragment()
                openFragment(userFragment)
            }
            R.id.nav_configuracion -> {
                configFragment = ConfigFragment()
                openFragment(configFragment)
            }
            R.id.nav_nosotros -> {
                acercaFragment = AcercaFragment()
                openFragment(acercaFragment)
            }
            R.id.nav_politica -> {
                politicaFragment = PoliticaFragment()
                openFragment(politicaFragment)
            }
            R.id.nav_salir -> {
                salirFragment = SalirFragment()
                openFragment(salirFragment)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_home, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

    override fun onBackPressed() {
        val drawer = binding.drawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}