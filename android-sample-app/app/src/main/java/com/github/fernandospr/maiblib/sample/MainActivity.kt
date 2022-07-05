package com.github.fernandospr.maiblib.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.fernandospr.maiblib.Example

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val example = Example()
        findViewById<TextView>(R.id.textView).text = example.hello("Fernando")
    }
}