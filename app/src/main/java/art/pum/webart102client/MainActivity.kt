package art.pum.webart102client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.BitmapCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import art.pum.webart102client.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMainActivity = DataBindingUtil.setContentView(this,
                                    R.layout.activity_main)
        val navController = this.findNavController(R.id.navHost)
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHost)
        return navController.navigateUp()
    }
}