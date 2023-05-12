import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandler.coreUi() {
    project(projectName = "ui")
}

fun DependencyHandler.forms() {
    project(projectName = "forms")
}

fun DependencyHandler.game() {
    project(projectName = "game")
}

fun DependencyHandler.utils() {
    project(projectName = "utils")
}

fun DependencyHandler.android() {
    implementation("androidx.core:core-ktx:${Versions.coreKtx}")
    implementation("androidx.appcompat:appcompat:${Versions.appCompat}")
    implementation("androidx.activity:activity-compose:${Versions.activityCompose}")
}

fun DependencyHandler.material() {
    implementation("com.google.android.material:material:${Versions.material}")
}

fun DependencyHandler.tests() {
    testImplementation("junit:junit:${Versions.jUnit}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.androidXJUnit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.espresso}")
}

fun DependencyHandler.coroutines() {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
}

fun DependencyHandler.koin() {
    // Koin Core features
    implementation("io.insert-koin:koin-core:${Versions.koin}")
    // Koin main features for Android
    implementation("io.insert-koin:koin-android:${Versions.koin}")

    // Jetpack Navigation
    implementation("io.insert-koin:koin-androidx-navigation:${Versions.koinAndroidNavigation}")
    // Jetpack Compose
    implementation("io.insert-koin:koin-androidx-compose:${Versions.koinAndroidCompose}")

    // Koin Test features
    testImplementation("io.insert-koin:koin-test:${Versions.koin}")
}

fun DependencyHandler.compose() {
    implementation("androidx.compose.ui:ui:${Versions.composeUi}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}")
    implementation("androidx.compose.material:material:${Versions.composeUi}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.composeUi}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.composeUi}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.composeUi}")
}

fun DependencyHandler.navigation() {
    implementation("androidx.navigation:navigation-compose:${Versions.navigation}")
}

private fun DependencyHandler.project(projectName: String) {
    implementation(project(":$projectName"))
}

private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)
