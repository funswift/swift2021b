package com.swift2021.ibashareandroid


import android.animation.ObjectAnimator
import android.os.Bundle
import android.content.Intent
import android.graphics.Rect
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
import com.swift2021.ibashareandroid.model.Place
import com.swift2021.ibashareandroid.model.User
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ibara = User("井原翔太", "美原町")
        val ibasyo1 = Place("富岡囲碁倶楽部","囲碁", "富岡町")
        val ibasyo2 = Place("美原あみあみもの倶楽部","編み物", "富岡町")
        val ibasyo3 = Place("昭和囲碁将棋の集い","囲碁", "富岡町")
        val ibasyo4 = Place("囲碁好きの集い","囲碁", "富岡町")
        val ibasyo5 = Place("編み物倶楽部","編み物", "富岡町")
        val ibasyo6 = Place("美原編み物サークル","編み物", "富岡町")
        val ibasyo7 = Place("美原編み物教室","編み物", "富岡町")
        val ibasyo8 = Place("美原イベントサークル","イベント", "富岡町")
        val ibasyo9 = Place("富岡将棋","将棋", "富岡町")
        val ibasyo10 = Place("将棋所","将棋", "富岡町")
        val ibasyo11 = Place("鍛治で将棋好き","将棋", "富岡町")
        val ibasyo12 = Place("将棋名人","将棋", "富岡町")


        place1.text = ibasyo1.name
        place2.text = ibasyo2.name
        place3.text = ibasyo3.name
        place4.text = ibasyo4.name

        val image1: ImageView = findViewById(R.id.image1)
        val image2: ImageView = findViewById(R.id.image2)
        val image3: ImageView = findViewById(R.id.image3)
        val image4: ImageView = findViewById(R.id.image4)

        val seeTownButton: Button = findViewById(R.id.seeTownButton)
        val seeMoreButton: Button = findViewById(R.id.seeMoreButton)


        image1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", ibasyo1.name)
            intent.putExtra("PlaceImage", 1)
            startActivity(intent)
        }

        image2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", ibasyo2.name)
            intent.putExtra("PlaceImage", 2)

            startActivity(intent)
        }

        image3.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", ibasyo3.name)
            intent.putExtra("PlaceImage", 3)
            startActivity(intent)
        }

        image4.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("PlaceName", ibasyo4.name)
            intent.putExtra("PlaceImage", 4)
            startActivity(intent)
        }

        initView()


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
        val imageView = arrayListOf<ImageView>(
            findViewById(R.id.imageRandomViewMain1),
            findViewById(R.id.imageRandomViewMain2),
            findViewById(R.id.imageRandomViewMain3),
            findViewById(R.id.imageRandomViewMain4)
        )
        val textView = arrayListOf<TextView>(
            findViewById(R.id.textViewMain1),
            findViewById(R.id.textViewMain2),
            findViewById(R.id.textViewMain3),
            findViewById(R.id.textViewMain4)
        )
        for (i in imageNames.indices) {
            imageView[i].setImageResource(imageNames[i])
            textView[i].text = textNames[i]
        }
        scrollView.setOnTouchListener { _, _ -> true }

        setRandomButtonEvent(imageView)
        timeEvent()
    }

    private fun timeEvent() {
        var handler = Handler((Looper.getMainLooper()))

        val rnb = object : Runnable {
            override fun run() {
                handler.postDelayed(this, 5000)
                animationPageEvent()
            }
        }
        handler.post(rnb)

    }

    private fun setRandomButtonEvent(imageViewList: ArrayList<ImageView>) {
        for (i in imageViewList.indices) {
            imageViewList[i].setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("PlaceName", textNames[i])
                intent.putExtra("PlaceImage", i)
                startActivity(intent)
            }
        }
    }

    private fun animationPageEvent() {
        val size = Rect()
        this.window.decorView.getWindowVisibleDisplayFrame(size)
        val amountOfMovementX = size.width() + 3

        val array = IntArray(2)
        imageRandomView.getLocationInWindow(array)
        val locationX = array[0]

        var moveToX: Int = (locationX - amountOfMovementX)
        if (locationX <= (amountOfMovementX) * (-2.5)) {
            moveToX = 0
        }
        if (locationX != 0) {
            ObjectAnimator.ofFloat(imageRandomView, "translationX", moveToX.toFloat()).apply {
                duration = 2000
                start()
            }
        }
    }

}