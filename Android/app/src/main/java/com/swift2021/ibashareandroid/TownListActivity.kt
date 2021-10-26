package com.swift2021.ibashareandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 1)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 2)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 3)
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 4)
            startActivity(intent)
        }

        button5.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 5)
            startActivity(intent)
        }

        button6.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 6)
            startActivity(intent)
        }

        button7.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 7)
            startActivity(intent)
        }

        button8.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 8)
            startActivity(intent)
        }

        button9.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 9)
            startActivity(intent)
        }

        button10.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 10)
            startActivity(intent)
        }

        button11.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 11)
            startActivity(intent)
        }

        button12.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 12)
            startActivity(intent)
        }

        button13.setOnClickListener {
            val intent = Intent(this@TownListActivity, SecondActivity::class.java)
            intent.putExtra("town", 13)
            startActivity(intent)
        }
    }

    // 戻るボタン
    fun onBackButtonTapped(view: View?) {
        finish()
    }
}