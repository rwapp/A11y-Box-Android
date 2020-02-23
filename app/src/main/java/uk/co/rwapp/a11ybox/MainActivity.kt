package uk.co.rwapp.a11ybox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
