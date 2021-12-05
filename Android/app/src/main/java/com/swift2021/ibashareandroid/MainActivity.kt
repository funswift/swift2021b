package com.swift2021.ibashareandroid


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
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

    val fujimon = UserData(
        "hU5yQWM3JN2eG4rdeWfO",
        "藤門千明",
        "将棋・囲碁",
        "編み物",
        "料理"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataAmimono: SharedPreferences =
            getSharedPreferences("DataAmimono", Context.MODE_PRIVATE)
        val dataShogi: SharedPreferences = getSharedPreferences("DataShogi", Context.MODE_PRIVATE)
        val dataIgo: SharedPreferences = getSharedPreferences("DataIgo", Context.MODE_PRIVATE)
        val dataCook: SharedPreferences = getSharedPreferences("DataCook", Context.MODE_PRIVATE)

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

        val seeTownButton: Button = findViewById(R.id.seeTownButton)
        val seeMoreRecommendButton: Button = findViewById(R.id.seeMoreRecommendButton)

        // ランダム
        val randomTextViewList =
            listOf<TextView>(textViewMain1, textViewMain2, textViewMain3, textViewMain4)
        val randomImageViewList = listOf<ImageView>(
            imageRandomViewMain1,
            imageRandomViewMain2,
            imageRandomViewMain3,
            imageRandomViewMain4
        )

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

        // あなたへのおすすめ
        val recommendTextViewList =
            listOf<TextView>(recommend_place1, recommend_place2, recommend_place3, recommend_place4)
        val recommendImageViewList = listOf<ImageView>(
            recommend_image1,
            recommend_image2,
            recommend_image3,
            recommend_image4
        )

        // 各ジャンルのTextView
        val genre1TextViewList = listOf<TextView>(
            genre1_place1_name,
            genre1_place2_name,
            genre1_place3_name,
            genre1_place4_name
        )
        val genre2TextViewList = listOf<TextView>(
            genre2_place1_name,
            genre2_place2_name,
            genre2_place3_name,
            genre2_place4_name
        )
        val genre3TextViewList = listOf<TextView>(
            genre3_place1_name,
            genre3_place2_name,
            genre3_place3_name,
            genre3_place4_name
        )

        // 各ジャンルのImageView
        val genre1ImageViewList =
            listOf<ImageView>(genre1_image1, genre1_image2, genre1_image3, genre1_image4)
        val genre2ImageViewList =
            listOf<ImageView>(genre2_image1, genre2_image2, genre2_image3, genre2_image4)
        val genre3ImageViewList =
            listOf<ImageView>(genre3_image1, genre3_image2, genre3_image3, genre3_image4)

        initView()

        // 各ジャンルのTitleView
        val genre1TitleTextView = Genre1TitleName
        val genre2TitleTextView = Genre2TitleName
        val genre3TitleTextView = Genre3TitleName
        val genreTitleList: List<TextView> =
            listOf(genre1TitleTextView, genre2TitleTextView, genre3TitleTextView)

        // Firebaseから居場所名をセット
        getPlaceName(randomTextViewList, "編み物")
        getPlaceName(recommendTextViewList, "将棋")

        // ジャンル名をFirestoreから
        getGenreName(genreTitleList)

        // 居場所名をFirestoreから
        getPlaceName(genre1TextViewList, "囲碁")
        getPlaceName(genre2TextViewList, "編み物")
        getPlaceName(genre3TextViewList, "将棋")

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


        //もっと見る
        seeMoreRecommendButton.setOnClickListener {
            // ジャンル1 → Tag1Activityへ
            val intent = Intent(this, RecommendActivity::class.java)
            startActivity(intent)
        }
        seeMoreGenre1Button.setOnClickListener {
            fujimon.tapIgo()
            val intent = Intent(this, Tag1Activity::class.java)
            startActivity(intent)
        }
        seeMoreGenre2Button.setOnClickListener {
            fujimon.tapAmimono()
            val intent = Intent(this, Tag2Activity::class.java)
            startActivity(intent)
        }
        seeMoreGenre3Button.setOnClickListener {
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
        navigation_icon_top_name.setTextColor(getColor(R.color.orange))


    }


    private fun initView() {
        horizontalScrollView.setOnTouchListener { _, _ -> true }

        timeEvent()
    }

    private fun setRandomImage(randomImageViewList: List<ImageView>, randomImagePath: List<Int>) {
        for (i in randomImageViewList.indices) {
            randomImageViewList[i].setImageResource(randomImagePath[i])
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
                handler.postDelayed(this, 5000)
                animationPageEvent()
            }
        }
        handler.post(rnb)

    }


    private fun animationPageEvent() {
        val size = Rect()
        this.window.decorView.getWindowVisibleDisplayFrame(size)
        val amountOfMovementX = size.width() + linear1.marginEnd / 2

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
                            Log.d(TAG, "userList[" + i + "].title " + placeList[i].title)
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

    fun onBackButton(view: View?){
        finish()
    }

}