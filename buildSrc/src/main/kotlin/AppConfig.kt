import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

object AppConfig {
    private const val appIdPrefix: String = "com.mikaelarmonia"
    const val applicationId: String = "$appIdPrefix.fizzbuzz"
    const val compileSdk: Int = 33
    const val minSdk: Int = 24
    const val targetSdk: Int = 24
    const val versionCode: Int = 1
    const val versionName: String = "1.0"
}

fun LibraryExtension.defaultAndroidModule(
    moduleName: String,
    testInstrumentationRunnerName: String = "androidx.test.runner.AndroidJUnitRunner",
    consumerProguardFiles: Array<Any> = arrayOf("consumer-rules.pro"),
    proguardFiles: Array<Any> = arrayOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"),
) {
    namespace = "${AppConfig.applicationId}.$moduleName"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = testInstrumentationRunnerName
        consumerProguardFiles(*consumerProguardFiles)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(*proguardFiles)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

fun BaseAppModuleExtension.defaultAndroidApp(
    appName: String,
    testInstrumentationRunnerName: String = "androidx.test.runner.AndroidJUnitRunner",
    proguardFiles: Array<Any> = arrayOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"),
) {
    namespace = "${AppConfig.applicationId}.$appName"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.mikaelarmonia.$appName"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionName = AppConfig.versionName

        testInstrumentationRunner = testInstrumentationRunnerName
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(*proguardFiles)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

private fun TestedExtension.kotlinOptions(configure: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)
}