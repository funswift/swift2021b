package com.swift2021.ibashareandroid


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.content.ContentValues.TAG
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.PorterDuff
import android.graphics.Rect
import  android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.core.content.ContextCompat
import androidx.core.view.marginEnd
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import android.widget.ViewFlipper
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.random_image_view.*
import kotlinx.android.synthetic.main.random_image_view.view.*

import android.graphics.drawable.Drawable
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.toppage_genre_layout.view.*


private var locationIndex = 1

class MainActivity : AppCompatActivity() {

    private val db = Firebase.firestore

    private val fujimon = UserData(
        "hU5yQWM3JN2eG4rdeWfO",
        "藤門千明",
        "将棋・囲碁",
        "編み物",
        "料理"
    )
    private var isTimeZero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataAmimono: SharedPreferences =
            getSharedPreferences("DataAmimono", MODE_PRIVATE)
        val dataShogi: SharedPreferences = getSharedPreferences("DataShogi", MODE_PRIVATE)
        val dataIgo: SharedPreferences = getSharedPreferences("DataIgo", MODE_PRIVATE)
        val dataCook: SharedPreferences = getSharedPreferences("DataCook", MODE_PRIVATE)

        var amimonoTap = dataAmimono.getInt("amimono", 0)
        var shogiTap = dataShogi.getInt("shogi", 0)
        var igoTap = dataIgo.getInt("igo", 0)
        var cookTap = dataCook.getInt("cook", 0)

        fujimon.amimono = amimonoTap
        fujimon.shogi = shogiTap
        fujimon.igo = igoTap
        fujimon.cook = cookTap

        db.collection("users").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document?.toObjects(PlaceData::class.java) != null) {
                    val genreList = document.toObjects(UserData::class.java)

                }
            } else {
                Log.d(TAG, "No such document")
            }
        }

        // 画像のパス
        val randomImagePath =
            listOf(R.mipmap.amimono01, R.mipmap.amimono02, R.mipmap.amimono03, R.mipmap.amimono04, R.mipmap.amimono03)
        val recommendImagePath =
            listOf(R.mipmap.shogi01, R.mipmap.shogi02, R.mipmap.shogi03, R.mipmap.shogi04)
        val genre1ImagePath =
            listOf(R.mipmap.igo01, R.mipmap.igo02, R.mipmap.igo03, R.mipmap.igo04)
        val genre2ImagePath =
            listOf(R.mipmap.amimono01, R.mipmap.amimono02, R.mipmap.amimono03, R.mipmap.amimono04)
        val genre3ImagePath =
            listOf(R.mipmap.shogi01, R.mipmap.shogi02, R.mipmap.shogi03, R.mipmap.shogi04)

        // 町名オレンジ
        navigation_icon_top_name.setTextColor(getColor(R.color.orange))

        // 町を選ぶ
        val seeTownButton: Button = findViewById(R.id.seeTownButton)


//         コンフリクトで消えた箇所↓
//         image1.setOnClickListener {
//             val intent = Intent(this, MainActivity2::class.java)
//             fujimon.tapAmimono()

//             intent.putExtra("PlaceName", placeName1.text.toString())
//             intent.putExtra("PlaceImage", 1)
//             var editorAmimono = dataAmimono.edit()
//             editorAmimono.putInt("amimono", fujimon.amimono)
//             editorAmimono.apply()
//             startActivity(intent)

//         }
        // 各ジャンルTitleのTextView
        val genre1TitleTextView = genre1_layout.GenreTitleName
        val genre2TitleTextView = genre2_layout.GenreTitleName
        val genre3TitleTextView = genre3_layout.GenreTitleName
        val genreTitleList: List<TextView> =
            listOf(genre1TitleTextView, genre2TitleTextView, genre3TitleTextView)

        // 各ジャンルのTextView
        val randomTextViewList =
            listOf<TextView>(
                firstView.randomTextView,
                secondView.randomTextView,
                thirdView.randomTextView,
                fourthView.randomTextView,
                fifthView.randomTextView
            )

        val recommendTextViewList =
            listOf<TextView>(
                recommend_layout.genre_place1,
                recommend_layout.genre_place2,
                recommend_layout.genre_place3,
                recommend_layout.genre_place4
            )

        val genre1TextViewList = listOf<TextView>(
            genre1_layout.genre_place1,
            genre1_layout.genre_place2,
            genre1_layout.genre_place3,
            genre1_layout.genre_place4
        )
        val genre2TextViewList = listOf<TextView>(
            genre2_layout.genre_place1,
            genre2_layout.genre_place2,
            genre2_layout.genre_place3,
            genre2_layout.genre_place4
        )
        val genre3TextViewList = listOf<TextView>(
            genre3_layout.genre_place1,
            genre3_layout.genre_place2,
            genre3_layout.genre_place3,
            genre3_layout.genre_place4
        )


        // 各ジャンルのImageView
        val randomImageViewList = listOf<ImageFilterButton>(
            firstView.randomImageButton,
            secondView.randomImageButton,
            thirdView.randomImageButton,
            fourthView.randomImageButton,
            fifthView.randomImageButton
        )

        val recommendImageViewList = listOf<ImageView>(
            recommend_layout.genre_image1,
            recommend_layout.genre_image2,
            recommend_layout.genre_image3,
            recommend_layout.genre_image4
        )

        val genre1ImageViewList =
            listOf<ImageView>(
                genre1_layout.genre_image1,
                genre1_layout.genre_image2,
                genre1_layout.genre_image3,
                genre1_layout.genre_image4
            )
        val genre2ImageViewList =
            listOf<ImageView>(
                genre2_layout.genre_image1,
                genre2_layout.genre_image2,
                genre2_layout.genre_image3,
                genre2_layout.genre_image4
            )
        val genre3ImageViewList =
            listOf<ImageView>(
                genre3_layout.genre_image1,
                genre3_layout.genre_image2,
                genre3_layout.genre_image3,
                genre3_layout.genre_image4
            )

        // ジャンルタイトルをFirestoreから
        getGenreName(genreTitleList)

        // 居場所名をFirestoreから
        getPlaceName(randomTextViewList, "編み物")
        getPlaceName(recommendTextViewList, "将棋")
        getPlaceName(genre1TextViewList, "囲碁")
        getPlaceName(genre2TextViewList, "編み物")
        getPlaceName(genre3TextViewList, "将棋")

        // ボタンのクリックイベント
        setButtonEvent(randomImageViewList, randomTextViewList)
        setButtonEvent(recommendImageViewList, recommendTextViewList)
        setButtonEvent(genre1ImageViewList, genre1TextViewList)
        setButtonEvent(genre2ImageViewList, genre2TextViewList)
        setButtonEvent(genre3ImageViewList, genre3TextViewList)

        // 画像をセット
        setImage(randomImageViewList, randomImagePath)
        setImage(recommendImageViewList, recommendImagePath)
        setImage(genre1ImageViewList, genre1ImagePath)
        setImage(genre2ImageViewList, genre2ImagePath)
        setImage(genre3ImageViewList, genre3ImagePath)

        //他の街を見る
        seeTownButton.setOnClickListener {
            val intent = Intent(this, TownListActivity::class.java)
            startActivity(intent)
        }

        //もっと見る
        recommend_layout.seeMoreGenreButton.setOnClickListener {
            // ジャンル1 → Tag1Activityへ
            val intent = Intent(this, RecommendActivity::class.java)
            startActivity(intent)
        }
        genre1_layout.seeMoreGenreButton.setOnClickListener {
            fujimon.tapIgo()
            val intent = Intent(this, Tag1Activity::class.java)
            startActivity(intent)
        }
        genre2_layout.seeMoreGenreButton.setOnClickListener {
            fujimon.tapAmimono()
            val intent = Intent(this, Tag2Activity::class.java)
            startActivity(intent)
        }
        genre3_layout.seeMoreGenreButton.setOnClickListener {
            fujimon.tapShogi()
            val intent = Intent(this, Tag3Activity::class.java)
            startActivity(intent)
        }

        //ナビゲーション
        navigation_icon_search_button.setOnClickListener {
            val intent = Intent(this, SearchPageActivity::class.java)
            startActivity(intent)
        }
        navigation_icon_talk_button.setOnClickListener {
            val intent = Intent(this, TalkPageActivity::class.java)
            startActivity(intent)
        }
        navigation_icon_my_page_button.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }


        initView()

    }

    private fun initView() {
        timeEvent()
        pointColorSet()
    }


    private fun pointColorSet() {
        point1.background = getDrawable(R.color.black)
        point2.background = getDrawable(R.color.gray_c4)
        point3.background = getDrawable(R.color.gray_c4)
        point4.background = getDrawable(R.color.gray_c4)
        point5.background = getDrawable(R.color.gray_c4)
    }

    private fun setImage(ImageViewList: List<ImageView>, ImagePath: List<Int>) {
        for (i in ImageViewList.indices) {
            ImageViewList[i].setImageResource(ImagePath[i])
        }
    }

    private fun setButtonEvent(
        imageViewList: List<ImageView>,
        placeNameTextViewList: List<TextView>
    ) {
        for (i in imageViewList.indices)
            imageViewList[i].setOnClickListener {
                when (i) {
                    0 -> {
                        fujimon.tapAmimono()
                    }
                    1 -> {
                        fujimon.tapIgo()
                    }
                    2 -> {
                        fujimon.tapShogi()
                    }
                    3 -> {
                        fujimon.tapIgo()
                    }

                }
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("PlaceName", placeNameTextViewList[i].text.toString())
                intent.putExtra("PlaceImage", i + 1)
                startActivity(intent)
            }
    }

    private fun timeEvent() {
        var handler = Handler((Looper.getMainLooper()))

        val rnb = object : Runnable {
            override fun run() {
                handler.postDelayed(this, 10000)
                if (!isTimeZero) {
                    changeCard(flipper)
                }
                isTimeZero = false
            }
        }
        handler.post(rnb)

    }

    private fun changeCard(viewFlipper: ViewFlipper) {
        viewFlipper.showNext()

        locationIndex = (locationIndex % 5) + 1
        when (locationIndex) {
            1 -> {
                point1.background = getDrawable(R.color.black)
                point5.background = getDrawable(R.color.gray_c4)
            }
            2 -> {
                point2.background = getDrawable(R.color.black)
                point1.background = getDrawable(R.color.gray_c4)
            }
            3 -> {
                point3.background = getDrawable(R.color.black)
                point2.background = getDrawable(R.color.gray_c4)
            }
            4 -> {
                point4.background = getDrawable(R.color.black)
                point3.background = getDrawable(R.color.gray_c4)
            }
            5 -> {
                point5.background = getDrawable(R.color.black)
                point4.background = getDrawable(R.color.gray_c4)

            }
        }
    }

    private fun getPlaceName(placeViewList: List<TextView>, genreName: String) {
        db.collection("place").whereEqualTo("genre", genreName).limit(4)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document?.toObjects(PlaceData::class.java) != null) {
                        val placeList = document.toObjects(PlaceData::class.java)
                        Log.d(TAG, "getDataAll")
                        Log.d(TAG, "placeList.size " + placeList.size)
                        for (i in 0 until placeList.size) {
                            Log.d(
                                TAG,
                                "userList[" + i + "].title " + placeList[i].title
                            )
//                            Log.d(TAG, "List[" + i + "].information " + placeList[i].information)
//                            Log.d(TAG, "userList[" + i + "].address " + placeList[i].address)
                            placeViewList[i].text = placeList[i].title
                        }
                    }
                } else {
                    Log.d(TAG, "No such document")
                }
            }
    }

    private fun getGenreName(genreTitleTextViewList: List<TextView>) {

        db.collection("users").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document?.toObjects(PlaceData::class.java) != null) {
                    val userList = document.toObjects(UserData::class.java)

//                    for (i in 0 until genreList.size) {
//                        Log.d(TAG, "userList[" + i + "].genre1 " + userList[i].genre1)
                    genreTitleTextViewList[0].text = userList[0].genre1
                    genreTitleTextViewList[1].text = userList[0].genre2
                    genreTitleTextViewList[2].text = userList[0].genre3
//                    }
                }
            } else {
                Log.d(TAG, "No such document")
            }
        }
    }

    fun onBackButton(view: View?) {
        finish()
    }

}