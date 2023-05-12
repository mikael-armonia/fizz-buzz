plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    defaultAndroidModule(moduleName = "game")
}

dependencies {
    android()
    material()
    compose()
    koin()
    coroutines()

    coreUi()
    forms()
    utils()

    tests()
}