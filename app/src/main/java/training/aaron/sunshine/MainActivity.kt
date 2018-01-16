package training.aaron.sunshine

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import com.softwaremobility.simplehttp.NetworkConnection
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @author: Aarón Negrete
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tootlbar)
        var permisos = arrayOf(Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.INTERNET)
        ActivityCompat.requestPermissions(this,permisos,100)

        NetworkConnection.testPath(resources.getString(R.string.baseUrl))
    }
}