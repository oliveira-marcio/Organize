package com.raywenderlich.organize

import com.raywenderlich.organize.Modules.initKoin
import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual val platformModule: Module = module {
  single<SqlDriver> {
    NativeSqliteDriver(OrganizeDb.Schema, "OrganizeDb")
  }
}

object KoinIOS {
  fun initialize(
    userDefaults: NSUserDefaults,
  ): KoinApplication = initKoin(appModule = module {
    single<Settings> {
      AppleSettings(userDefaults)
    }
  })
}

fun Koin.get(objCClass: ObjCClass): Any {
  val kClazz = getOriginalKotlinClass(objCClass)!!
  return get(kClazz, null, null)
}