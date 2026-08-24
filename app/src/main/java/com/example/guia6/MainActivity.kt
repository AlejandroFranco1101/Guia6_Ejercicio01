package com.example.guia6

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickFrame(view: View?) {
        startActivity(Intent(this, FrameLayout::class.java))
    }

    fun onClickLinear(view: View?) {
        startActivity(Intent(this, LinearLayout::class.java))
    }

    fun onClickRelative(view: View?) {
        startActivity(Intent(this, RelativeLayout::class.java))
    }

    fun onClickTable(view: View?) {
        startActivity(Intent(this, TableLayout::class.java))
    }

    fun onClickContraint(view: View?) {
        startActivity(Intent(this, ConstraintLayout::class.java))
    }

    fun onClickGrid(view: View?) {
        startActivity(Intent(this, GridLayout::class.java))
    }
}
