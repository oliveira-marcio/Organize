package com.raywenderlich.organize

actual class Logger {
  actual companion object {
    actual fun log(
      message: String?,
      tag: String,
      level: LogLevel
    ) {
      message?.let {
        print("${level.name}/$tag: $message")
      }
    }
  }
}