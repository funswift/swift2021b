package com.swift2021.ibashareandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_place_detail_page.*
import kotlinx.android.synthetic.main.fragment_place_detail_page.button_send
import kotlinx.android.synthetic.main.fragment_see_more_page.*

class SeeMorePageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_see_more_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBackButtonEvent()
    }

    private fun setBackButtonEvent(){
        button_send.setOnClickListener {
            findNavController().navigate(R.id.action_see_more_to_top)
        }
    }
}