plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.2.0-alpha01")
    implementation(kotlin("gradle-plugin", "1.8.21"))
    implementation(kotlin("stdlib", "1.8.21"))
}
