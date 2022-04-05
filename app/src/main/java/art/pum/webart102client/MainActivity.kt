package art.pum.webart102client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.graphics.BitmapCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import art.pum.webart102client.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMainActivity = DataBindingUtil.setContentView(this,
                                    R.layout.activity_main)
        val navController = this.findNavController(R.id.navHost)
        NavigationUI.setupActionBarWithNavController(this, navController)

        bindingMainActivity.fab.setOnClickListener {
            val snack = Snackbar.make(it, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                snack.setAction("Exit", View.OnClickListener { finish() })
                snack.show()

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHost)
        return navController.navigateUp()
    }
}