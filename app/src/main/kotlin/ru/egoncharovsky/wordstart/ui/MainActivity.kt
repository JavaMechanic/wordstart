package ru.egoncharovsky.wordstart.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.sdk25.coroutines.onClick
import ru.egoncharovsky.wordstart.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityContent().setContentView(this)
    }
}

class MainActivityContent : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        frameLayout {
            val textField = editText {
                hint = "Text for toasts and snackbars"
            }.lparams(width = matchParent) {
                margin = dip(12)
                topMargin = dip(30)
            }

            imageView(R.drawable.ic_android_black_24dp) {
                onClick {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        this@imageView.imageTintList =
                                ColorStateList.valueOf(Color.parseColor("#4CAF50"))
                }
            }.lparams (dip(72), dip(72)) {
                gravity = Gravity.CENTER
            }

            linearLayout {
                button("Show toast") {
                    onClick {
                        toast(textField.text)
                    }
                }

                button("Show snackbar") {
                    onClick {
                        longSnackbar(this@frameLayout, textField.text.toString())
                    }
                }
            }.lparams {
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(72)
            }
        }
    }

}