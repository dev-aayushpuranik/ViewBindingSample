package com.example.viewbindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.viewbindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        // setting data after binding
        binding.dataTV.text = "View Binding"
        binding.clickActionBtn.setOnClickListener {
            binding.activityParentLayout.visibility = View.GONE
            supportFragmentManager.beginTransaction()
                    .replace(R.id.parentLayout,VBFragment())
                    .addToBackStack("nav")
                    .commit()
        }
    }

    override fun onResume() {
        super.onResume()

        binding.activityParentLayout.visibility = View.VISIBLE
    }
}