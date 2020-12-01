@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.eminesa.udacityproject1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.eminesa.udacityproject1.databinding.ActivityMainBinding
import com.eminesa.udacityproject1.helper.CacheHelper
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var cacheHelper: CacheHelper? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navHostFragment = myNavHostFragment as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.navigation_graph)

        cacheHelper = CacheHelper(this)
        val cacheEmail = cacheHelper?.fetchUserName()
        val cachePassword = cacheHelper?.fetchUserPassword()

        if (cacheEmail != null  && cachePassword != null){
            graph.startDestination = R.id.welcomeScreenFragment
            navHostFragment.navController.graph = graph
            appBarConfiguration = AppBarConfiguration(graph)
        }else
        {
            graph.startDestination = R.id.loginFragment
            navHostFragment.navController.graph = graph
            appBarConfiguration = AppBarConfiguration(graph)
        }

        // added back icon
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)

    }

    /** added action to back icon */
    override fun onSupportNavigateUp(): Boolean {
        Timber.i("call back button")
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

}