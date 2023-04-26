package com.raywenderlich.organize

import platform.Foundation.NSLog

actual class Logger {
  actual companion object {
    actual fun log(
      message: String?,
      tag: String,
      level: LogLevel
    ) {
      message?.let {
        NSLog("${level.name}/$tag: $it")
      }
    }
  }
}