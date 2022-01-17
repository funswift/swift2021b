package com.swift2021.ibashareandroid

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_see_more_tag1.*
import kotlinx.android.synthetic.main.fragment_place_detail_page.*

class PlaceDetailPageFragment : Fragment() {

    private val args: PlaceDetailPageFragmentArgs by navArgs()

    private val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_detail_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        when (0) {
            0 -> imageView.setImageResource(R.mipmap.templete)
            1 -> imageView.setImageResource(R.mipmap.shogi01)
            2 -> imageView.setImageResource(R.mipmap.shogi02)
            3 -> imageView.setImageResource(R.mipmap.shogi03)
            4 -> imageView.setImageResource(R.mipmap.shogi04)
        }

        seeMoreKutikomiButton.setOnClickListener {
            findNavController().navigate(R.id.action_place_detail_to_all_review)
        }
        seeMoreParticipantButton.setOnClickListener {
            findNavController().navigate(R.id.action_place_detail_to_participant)
        }

        button_send.setOnClickListener {
            findNavController().navigate(R.id.action_place_detail_to_top)
        }

        setPlaceName(args.placeName)


    }

    private fun setPlaceName(placeKey: String) {
        db.collection("place")
            .document(placeKey)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document != null && document.data != null) {
                        Log.d(TAG, "getData")
                        placeName.text = document.data?.get("title").toString()
                    } else {
                        Log.d(TAG, "No such document")
                    }
                } else {
                    Log.d(TAG, "get failed with " + task.exception)
                }
            }
            .addOnFailureListener { e -> Log.d(TAG, "Error adding document$e") }
    }

}