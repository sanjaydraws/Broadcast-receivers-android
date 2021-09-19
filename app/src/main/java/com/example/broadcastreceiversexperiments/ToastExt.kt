package com.example.broadcastreceiversexperiments

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * ```
 * author: Sanjay Prajapat
 * blog  : https://dev.to/sanjaydraws
 * created on  18/9/2021
 * ```
 */

/**
 * short toast
 * */
fun Context.toast(content: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, content, duration).apply {
        show()
    }
}

/**
 * pass string id
 */
fun Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    toast(getString(id), duration)
}


fun Any.toast(context: Context, @StringRes id: Int, duration: Int=Toast.LENGTH_SHORT) {
    context.toast(id, duration)
}


fun Context.longToast(content: String) {
    toast(content, Toast.LENGTH_LONG)
}