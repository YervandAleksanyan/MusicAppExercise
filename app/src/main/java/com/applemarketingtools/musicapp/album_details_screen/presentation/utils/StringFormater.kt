package com.applemarketingtools.musicapp.album_details_screen.presentation.utils

import android.content.Context
import com.applemarketingtools.musicapp.R
import java.text.SimpleDateFormat
import java.util.*

class StringFormatter(private val context: Context) {

    fun prepareReleaseDate(date: String): String {
        val dateFormat = getFromDateTime(date)

        return String.format(context.getString(R.string.release_date), dateFormat.orEmpty())
    }

    private fun getFromDateTime(dateTime: String): String? {

        return try {
            val dt = SimpleDateFormat("yyyyy-mm-dd", Locale.US)
            val date = dt.parse(dateTime)
            val dt1 = SimpleDateFormat("MMM dd, yyyy", Locale.US)
            date?.let { dt1.format(it) }
        } catch (e: Exception) {
            null
        }
    }
}
