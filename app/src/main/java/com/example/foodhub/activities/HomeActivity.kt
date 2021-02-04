package com.example.foodhub.activities

import android.graphics.Color
import android.os.Bundle
import android.system.Os.close
import android.system.Os.open
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
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
import androidx.fragment.app.FragmentTransaction
import com.example.foodhub.R
import com.example.foodhub.databinding.ActivityHomeBinding
import com.example.foodhub.fragments.fragmentsHome.*
import com.infideap.drawerbehavior.AdvanceDrawerLayout

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    lateinit var acercaFragment: AcercaFragment
    lateinit var configFragment: ConfigFragment
    lateinit var homeFragment: HomeFragment
    lateinit var politicaFragment: PoliticaFragment
    lateinit var salirFragment: SalirFragment
    lateinit var userFragment: UserFragment

    lateinit var drawer:AdvanceDrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        config()


        // Inicializando este libreria
        drawer = binding.drawerLayout

        drawer.useCustomBehavior(GravityCompat.START)
        drawer.useCustomBehavior(GravityCompat.END)
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
        actionBar?.title = "Food Hub"

        //Creando el toogle del Drawer
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


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                openFragment(homeFragment)
            }
            R.id.nav_perfil -> {
                openFragment(userFragment)
            }
            R.id.nav_configuracion -> {
                openFragment(configFragment)
            }
            R.id.nav_nosotros -> {
                openFragment(acercaFragment)
            }
            R.id.nav_politica -> {
                openFragment(politicaFragment)
            }
            R.id.nav_salir -> {
                openFragment(salirFragment)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
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

    fun config() {
        // window.statusBarColor = Color.rgb(246,46,15)
        window.setBackgroundDrawableResource(R.color.white)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }


}