plugins {
    `android-library`
    `kotlin-android`
}

android {
    defaultAndroidModule(moduleName = "utils")
}

dependencies {
    android()
    tests()
}
