import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    // DI
    const val koin = "3.4.0"
    const val koinAndroidCompose = "3.4.4"
    const val koinAndroidNavigation = "3.4.0"


    // region Android
    // Core
    const val coreKtx = "1.10.0"
    const val appCompat = "1.6.1"
    const val activityCompose = "1.6.1"
    // Coroutines
    const val coroutines = "1.6.4"

    // Compose
    const val composeCompiler = "1.4.4"
    const val composeUi = "1.4.3"

    // Navigation
    const val navigation = "2.5.3"

    // Material
    const val material = "1.9.0"

    // Tests
    const val jUnit = "4.13.2"
    const val androidXJUnit = "1.1.5"
    const val espresso = "3.5.1"
    // endregion
}
