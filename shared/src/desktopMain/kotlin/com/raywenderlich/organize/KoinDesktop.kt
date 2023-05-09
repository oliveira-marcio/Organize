package com.raywenderlich.organize

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.JvmPreferencesSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.module
import java.util.prefs.Preferences

@ExperimentalSettingsImplementation
actual val platformModule = module {
  single {
    Preferences.userRoot()
  }
  single<Settings> {
    JvmPreferencesSettings(get())
  }
}