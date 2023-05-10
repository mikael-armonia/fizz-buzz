plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    defaultAndroidModule(moduleName = "forms")
}

dependencies {
    android()
    material()
    compose()
    koin()

    tests()
}