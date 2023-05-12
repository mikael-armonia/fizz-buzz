plugins {
    android
    `kotlin-android`
}

android {
    defaultAndroidApp(appName = "app")
}

dependencies {
    android()
    material()
    compose()
    navigation()
    koin()

    coreUi()
    forms()
    game()

    tests()
}