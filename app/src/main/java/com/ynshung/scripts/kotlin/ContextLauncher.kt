package com.ynshung.scripts.kotlin

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity


class ContextLauncher(private val context: Context) {
    fun launchWebsite(url: String) {
        startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse(url)), null)
    }

    fun launchLanguageSettings() {
        val intent = Intent(Intent.ACTION_MAIN)
            .setClassName(
                "com.android.settings",
                "com.android.settings.LanguageSettings"
            )
        startActivity(context, intent, null)
    }

    fun composeEmail(subject: String) {
        val emailArray = arrayOf("example@example.com")
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, emailArray)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)

        try {
            startActivity(context, intent, null)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                context,
                "No email application found",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun showToast(message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun returnContext(): Context {
        return context
    }
}