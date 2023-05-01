package com.raywenderlich.organize.presentation

import com.raywenderlich.organize.data.RemindersRepository
import com.raywenderlich.organize.domain.Reminder

class RemindersViewModel : BaseViewModel() {
  private val repository = RemindersRepository()

  internal val reminders: List<Reminder>
    get() = repository.reminders

  var onRemindersUpdated: ((List<Reminder>) -> Unit)? = null
    set(value) {
      field = value
      onRemindersUpdated?.invoke(reminders)
    }

  val title = "Reminders"

  fun createReminder(title: String) {
    val trimmed = title.trim()
    if (trimmed.isNotEmpty()) {
      repository.createReminder(title = trimmed)
      onRemindersUpdated?.invoke(reminders)
    }
  }

  fun markReminder(id: String, isCompleted: Boolean) {
    repository.markReminder(id = id, isCompleted = isCompleted)
    onRemindersUpdated?.invoke(reminders)
  }
}
