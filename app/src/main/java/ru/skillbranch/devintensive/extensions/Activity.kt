package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*


fun Activity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm!!.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Activity.isKeyboardOpen(): Boolean {
    val activityRootView = activityRoot
    var result = false
    activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            val r = Rect()
            activityRootView.getWindowVisibleDisplayFrame(r)
            val heightDiff: Int = activityRootView.rootView.height - (r.bottom - r.top)
            result = heightDiff > 100
        }
    })
    return result
}

fun Activity.isKeyboardClosed(): Boolean {
    val activityRootView = activityRoot
    var result = false
    activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            val r = Rect()
            activityRootView.getWindowVisibleDisplayFrame(r)
            val heightDiff: Int = activityRootView.rootView.height - (r.bottom - r.top)
            result = heightDiff < 100
        }
    })
    return result
}

