package com.telolahy.guitarmemo

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Created by stephanohuguestelolahy on 12/8/14.
 */
object TextUtil {
    fun readRawTextFile(context: Context, filePath: String): String? {
        val text = StringBuilder()
        try {
            val inputStream = context.assets.open(filePath)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String?

            while ((reader.readLine().also { line = it }) != null) {
                text.append(line)
                text.append('\n')
            }
        } catch (e: IOException) {
            return null
        }
        return text.toString()
    }
}
