package io.dilky.changeappicon

import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.dilky.changeappicon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChange.setOnClickListener {
            packageManager.setComponentEnabledSetting(
                ComponentName(this@MainActivity, MainActivity::class.java)
                , PackageManager.COMPONENT_ENABLED_STATE_DISABLED
                , PackageManager.DONT_KILL_APP)
            packageManager.setComponentEnabledSetting(
                ComponentName(this@MainActivity, MainActivityAlias1::class.java)
                , PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                , PackageManager.DONT_KILL_APP)
        }

        binding.buttonOrigin.setOnClickListener {
            packageManager.setComponentEnabledSetting(
                ComponentName(this@MainActivity, MainActivity::class.java)
                , PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                , PackageManager.DONT_KILL_APP)
            packageManager.setComponentEnabledSetting(
                ComponentName(this@MainActivity, MainActivityAlias1::class.java)
                , PackageManager.COMPONENT_ENABLED_STATE_DISABLED
                , PackageManager.DONT_KILL_APP)
        }

    }
}