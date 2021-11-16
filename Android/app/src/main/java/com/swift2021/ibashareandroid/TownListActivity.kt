package com.swift2021.ibashareandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_townlist.*

class TownListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_townlist)

        val button1 = findViewById<Button>(R.id.town1)
        val button2 = findViewById<Button>(R.id.town2)
        val button3 = findViewById<Button>(R.id.town3)
        val button4 = findViewById<Button>(R.id.town4)
        val button5 = findViewById<Button>(R.id.town5)
        val button6 = findViewById<Button>(R.id.town6)
        val button7 = findViewById<Button>(R.id.town7)
        val button8 = findViewById<Button>(R.id.town8)
        val button9 = findViewById<Button>(R.id.town9)
        val button10 = findViewById<Button>(R.id.town10)
        val button11 = findViewById<Button>(R.id.town11)
        val button12 = findViewById<Button>(R.id.town12)
        val button13 = findViewById<Button>(R.id.town13)

        button1.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button1.text.toString())
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button2.text.toString())
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button3.text.toString())
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button4.text.toString())
            startActivity(intent)
        }

        button5.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button5.text.toString())
            startActivity(intent)
        }

        button6.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button6.text.toString())
            startActivity(intent)
        }

        button7.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button7.text.toString())
            startActivity(intent)
        }

        button8.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button8.text.toString())
            startActivity(intent)
        }

        button9.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button9.text.toString())
            startActivity(intent)
        }

        button10.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button10.text.toString())
            startActivity(intent)
        }

        button11.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button11.text.toString())
            startActivity(intent)
        }

        button12.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button12.text.toString())
            startActivity(intent)
        }

        button13.setOnClickListener {
            val intent = Intent(this@TownListActivity, TownActivity::class.java)
            intent.putExtra("town", button13.text.toString())
            startActivity(intent)
        }
    }

    // 戻るボタン
    fun onBackButtonTapped(view: View?) {
        finish()
    }
}