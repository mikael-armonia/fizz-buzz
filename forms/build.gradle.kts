plugins {
    `android-library`
    `kotlin-android`
}

android {
    defaultAndroidModule(moduleName = "forms")
}

dependencies {
    android()
    material()
    compose()
    koin()

    utils()

    tests()
}