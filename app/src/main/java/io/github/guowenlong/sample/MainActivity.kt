package io.github.guowenlong.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import io.github.guowenlong.debounce.setDebounceClickListener
import io.github.guowenlong.debounce.setTriggerDefaultInterval

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tempTime = System.currentTimeMillis()
        setTriggerDefaultInterval(1000)
        findViewById<TextView>(R.id.tv_content).setDebounceClickListener {
            Toast.makeText(this, "时间(毫秒)${System.currentTimeMillis()-tempTime}", Toast.LENGTH_SHORT).show()
            tempTime = System.currentTimeMillis()
        }

        findViewById<TextView>(R.id.tv_bottom).setDebounceClickListener(2000) {
            Toast.makeText(this, "时间(毫秒)${System.currentTimeMillis()-tempTime}", Toast.LENGTH_SHORT).show()
            tempTime = System.currentTimeMillis()
        }
    }
}