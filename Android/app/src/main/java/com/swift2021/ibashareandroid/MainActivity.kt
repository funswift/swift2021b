package com.swift2021.ibashareandroid


import android.content.ContentValues.TAG
import android.os.Bundle
import android.content.Intent
import android.media.Image
import  android.widget.Button
import  android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var imageNames = arrayOf(
        R.drawable.amimono,
        R.drawable.igo01,
        R.drawable.shogi,
        R.drawable.igo02
    )
    private var textNames = arrayOf("美原編み物クラブ", "囲碁クラブ", "将棋会館", "囲碁同好会")
    private var aryIndex = 0

    private val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val placeName1: TextView = findViewById(R.id.place1)
        val placeName2: TextView = findViewById(R.id.place2)
        val placeName3: TextView = findViewById(R.id.place3)
        val placeName4: TextView = findViewById(R.id.place4)

        val image1: ImageView = findViewById(R.id.image1)
        val image2: ImageView = findViewById(R.id.image2)
        val image3: ImageView = findViewById(R.id.image3)
        val image4: ImageView = findViewById(R.id.image4)

        val seeTownButton: Button = findViewById(R.id.seeTownButton)
        val seeMoreButton: Button = findViewById(R.id.seeMoreButton)

        getData()

        image1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName1.text.toString())
            intent.putExtra("PlaceImage", 1)
            startActivity(intent)
        }

        image2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName2.text.toString())
            intent.putExtra("PlaceImage", 2)

            startActivity(intent)
        }

        image3.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName3.text.toString())
            intent.putExtra("PlaceImage", 3)
            startActivity(intent)
        }

        image4.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", placeName4.text.toString())
            intent.putExtra("PlaceImage", 4)
            startActivity(intent)
        }

        initView()
        timeEvent()

        //他の街を見る
        seeTownButton.setOnClickListener {
            val intent = Intent(this, TownListActivity::class.java)
            startActivity(intent)
        }

        //もっと見る
        seeMoreButton.setOnClickListener {
            val intent = Intent(this, RecommendActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initView() {
        val imageView: ImageView = findViewById(R.id.imageViewMain)
        val textView: TextView = findViewById(R.id.textViewMain)

        imageView.setImageResource(imageNames[aryIndex])
        textView.text = textNames[aryIndex]
    }

    private fun timeEvent() {
        var handler = Handler((Looper.getMainLooper()))

        val rnb = object : Runnable {
            override fun run() {
                handler.postDelayed(this, 5000)
                imageChange()
            }
        }
        handler.post(rnb)

    }

    private fun imageChange() {
        val imageView: ImageView = findViewById(R.id.imageViewMain)
        val textView: TextView = findViewById(R.id.textViewMain)

        imageView.setImageResource(imageNames[aryIndex])
        textView.text = textNames[aryIndex]

        aryIndex = (aryIndex + 1) % textNames.size
    }

    private fun getData() {
        val placeViewList = listOf<TextView>(place1, place2, place3, place4)
        db.collection("place").limit(4)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document?.toObjects(Place::class.java) != null) {
                        val placeList = document.toObjects(Place::class.java)
                        Log.d(TAG, "getDataAll")
                        Log.d(TAG, "userList.size " + placeList.size)
                        for (i in 0 until placeList.size) {
                            Log.d(TAG, "userList[" + i + "].title " + placeList[i].title)
                            Log.d(TAG, "List[" + i + "].information " + placeList[i].information)
                            Log.d(TAG, "userList[" + i + "].address " + placeList[i].address)
                            placeViewList[i].text = placeList[i].title
                        }
                    }
                } else {
                    Log.d(TAG, "No such document")
                }
            }

    }

}