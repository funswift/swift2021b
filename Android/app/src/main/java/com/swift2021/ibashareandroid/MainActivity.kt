package com.swift2021.ibashareandroid


import android.content.ContentValues.TAG
import android.animation.ObjectAnimator
import android.os.Bundle
import android.content.Intent
import android.graphics.Rect
import  android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginEnd
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {


    private val randomImagePath = listOf(
        R.drawable.amimono,
        R.drawable.igo01,
        R.drawable.shogi,
        R.drawable.igo02
    )


    private var aryIndex = 0

    private val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seeTownButton: Button = findViewById(R.id.seeTownButton)

        // ランダム
        val randomTextViewList = listOf<TextView>(textViewMain1, textViewMain2, textViewMain3, textViewMain4)
        val randomImageViewList = listOf<ImageView>(imageRandomViewMain1, imageRandomViewMain2, imageRandomViewMain3, imageRandomViewMain4)

        // あなたへのおすすめ
        val recommendTextViewList = listOf<TextView>(recommend_place1, recommend_place2, recommend_place3, recommend_place4)
        val recommendImageViewList = listOf<ImageView>(recommend_image1, recommend_image2, recommend_image3, recommend_image4)

        // 各ジャンルのTextView
        val genre1TextViewList = listOf<TextView>(genre1_place1_name, genre1_place2_name, genre1_place3_name, genre1_place4_name)
        val genre2TextViewList = listOf<TextView>(genre2_place1_name, genre2_place2_name, genre2_place3_name, genre2_place4_name)
        val genre3TextViewList = listOf<TextView>(genre3_place1_name, genre3_place2_name, genre3_place3_name, genre3_place4_name)

        // 各ジャンルのImageView
        val genre1ImageViewList = listOf<ImageView>(genre1_image1, genre1_image2, genre1_image3, genre1_image4)
        val genre2ImageViewList = listOf<ImageView>(genre2_image1, genre2_image2, genre2_image3, genre2_image4)
        val genre3ImageViewList = listOf<ImageView>(genre3_image1, genre3_image2, genre3_image3, genre3_image4)

        initView()

        // 各ジャンルのTitleView
        val genre1TitleTextView = Genre1TitleName
        val genre2TitleTextView = Genre2TitleName
        val genre3TitleTextView = Genre3TitleName

        // Firebaseから居場所名をセット
        getPlaceName(randomTextViewList)
        getPlaceName(recommendTextViewList)

        // ジャンル名をFirestoreから
        getGenreName(genre1TitleTextView)
        getGenreName(genre2TitleTextView)
        getGenreName(genre3TitleTextView)

        // 居場所名をFirestoreから
        getPlaceName(genre1TextViewList)
        getPlaceName(genre2TextViewList)
        getPlaceName(genre3TextViewList)

        // ボタンのクリックイベント
        setButtonEvent(randomImageViewList, randomTextViewList)
        setButtonEvent(recommendImageViewList, recommendTextViewList)
        setButtonEvent(genre1ImageViewList, genre1TextViewList)
        setButtonEvent(genre2ImageViewList, genre2TextViewList)
        setButtonEvent(genre3ImageViewList, genre3TextViewList)

        // ランダム部の画像をセット
        setRandomImage(recommendImageViewList, randomImagePath)

        //他の街を見る
        seeTownButton.setOnClickListener {
            val intent = Intent(this, TownListActivity::class.java)
            startActivity(intent)
        }

        // もっと見る
        // ジャンル1 → Tag1Activityへ
        seeMoreRecommendButton.setOnClickListener {
            val intent = Intent(this, RecommendActivity::class.java)
            startActivity(intent)
        }
        seeMoreGenre1Button.setOnClickListener {
            val intent = Intent(this, Tag1Activity::class.java)
            startActivity(intent)
        }
        seeMoreGenre2Button.setOnClickListener {
            val intent = Intent(this, Tag2Activity::class.java)
            startActivity(intent)
        }
        seeMoreGenre3Button.setOnClickListener {
            val intent = Intent(this, Tag3Activity::class.java)
            startActivity(intent)
        }

    }

    private fun initView() {
        horizontalScrollView.setOnTouchListener { _, _ -> true }

        timeEvent()
    }

    private fun setRandomImage(randomImageViewList: List<ImageView>, randomImagePath: List<Int>){
        for (i in randomImageViewList.indices) {
            randomImageViewList[i].setImageResource(randomImagePath[i])
        }
    }

    private fun setButtonEvent(imageViewList: List<ImageView>, placeNameTextViewList:List<TextView>){
        for(i in imageViewList.indices)
        imageViewList[i].setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("PlaceName", placeNameTextViewList[i].text.toString())
            intent.putExtra("PlaceImage", i+1)
            startActivity(intent)
        }
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


    private fun animationPageEvent() {
        val size = Rect()
        this.window.decorView.getWindowVisibleDisplayFrame(size)
        val amountOfMovementX = size.width() + linear1.marginEnd/2

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

    private fun getPlaceName(placeViewList: List<TextView>){
        db.collection("place").limit(4)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document?.toObjects(PlaceData::class.java) != null) {
                        val placeList = document.toObjects(PlaceData::class.java)
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

    private fun getGenreName(genreTitleTextView: TextView) {

        db.collection("users").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document?.toObjects(PlaceData::class.java) != null) {
                    val genreList = document.toObjects(UserData::class.java)

                    for (i in 0 until genreList.size) {
                        Log.d(TAG, "userList[" + i + "].genre1 " + genreList[i].genre1)
                        genreTitleTextView.text = genreList[i].genre1
                    }
                }
            } else {
                Log.d(TAG, "No such document")
            }
        }
    }

}