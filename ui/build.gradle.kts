plugins {
    `android-library`
    `kotlin-android`
}

android {
    defaultAndroidModule(moduleName = "ui")
}

dependencies {
    android()
    material()
    compose()
    navigation()

    tests()
}