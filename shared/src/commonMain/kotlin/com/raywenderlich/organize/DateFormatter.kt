package com.raywenderlich.organize

expect object DateFormatter {
  fun formatEpoch(epoch: Long): String
}