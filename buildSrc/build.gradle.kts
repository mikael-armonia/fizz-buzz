plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.0.1")
    implementation(kotlin("gradle-plugin", "1.8.10"))
    implementation(kotlin("stdlib", "1.8.10"))
}
