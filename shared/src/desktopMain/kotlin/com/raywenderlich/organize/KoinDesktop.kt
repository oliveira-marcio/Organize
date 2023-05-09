package com.raywenderlich.organize

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.JvmPreferencesSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
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
  single<SqlDriver> {
    // For testing purposes
    // val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)”
    val driver = JdbcSqliteDriver("jdbc:sqlite:OrganizeDb.db")
    // Should be called only once. For production apps, we should implement logic to handle this
    // OrganizeDb.Schema.create(driver)
    driver
  }
}