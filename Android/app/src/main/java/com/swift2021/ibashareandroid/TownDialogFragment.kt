package com.swift2021.ibashareandroid

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class TownDialogFragment(town : String) : DialogFragment() {
    val town: String

    init {
        this.town = town
    }
    override fun onCreateDialog(savedInstanceState: Bundle?) : Dialog {
        // ダイアログを生成するビルダーを生成します。
        val builder = AlertDialog.Builder(activity)
        val singleItems = arrayOf("富岡町", "美原町", "鍛冶町")
        val checkedItem = 1
        var selectItem:Int? = null

        // タイトルを設定
        builder.setTitle("他の町を探す")

        // 他の町の候補を選択
        builder.setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
            selectItem = which
        }

        // ポジティブボタンを設定
        builder.setPositiveButton("はい", DialogButtonClickListener(town))

        // ネガティブボタンを設定
        builder.setNegativeButton("いいえ", DialogButtonClickListener(town))

        // ダイアログを生成し、返却
        val dialog = builder.create()
        return dialog

    }

    // ダイアログボタンにクリックリスナークラス
    private inner class DialogButtonClickListener(town : String) : DialogInterface.OnClickListener {
        val town: String
        init {
            this.town = town
        }

        // ダイアログボタンがクリックされた時に呼び出されます。
        override fun onClick(dialog: DialogInterface?, which: Int) {
            // クリックされたボタンにより処理を振り分けます。
            var msg = ""
            when (which) {
                // ポジティブボタンの場合
                DialogInterface.BUTTON_POSITIVE ->
                    msg = "選択した町は${town}です。"

                // ネガティブボタンの場合
//                DialogInterface.BUTTON_NEGATIVE ->
//                    msg = "選択したフルーツは表示しません。"

            }
            // クリックされたボタンによりメッセージをトースト表示します。
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}