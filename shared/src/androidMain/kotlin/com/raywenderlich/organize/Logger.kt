package com.raywenderlich.organize

import android.util.Log

actual class Logger {
  actual companion object {
    actual fun log(
      message: String?,
      tag: String,
      level: LogLevel
    ) {
      message?.let {
        when (level) {
          LogLevel.DEBUG -> Log.d(tag, it)
          LogLevel.WARN -> Log.w(tag, it)
          LogLevel.ERROR -> Log.e(tag, it)
        }
      }
    }
  }
}