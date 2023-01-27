object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val daggerHilt = "com.google.dagger.hilt.android"
    const val kotlinKapt = "kotlin-kapt"
    const val koltinParcelize = "kotlin-parcelize"
}

object Versions {
    val compose = "1.4.0-alpha03"
    val material3 = "1.1.0-alpha03" // 5
    val constraintLayout = "1.0.1"
    val navigation = "2.5.3"
    val lifecycle = "2.6.0-alpha03"
    val coroutine = "1.6.4"
    val daggerHilt = "2.44.2"
    val hiltCompiler = "1.0.0"
    val hiltNavigationCompose = "1.0.0"
    val hiltWork = "1.0.0"
    val logcat = "0.1"
    val coil = "2.2.2"
    val jUnit4 = "4.13.2"

    // Retrofit
    val retrofit = "2.9.0"

    // OkHttp3
    val okHttp3 = "5.0.0-alpha.10"

    // Room
    val room = "2.4.3"

    // WorkManager
    val workManager = "2.7.1"

    // Gradle Plugins
    val kotlinAndroid = "1.7.21"
    val kotlinJvm = "1.7.21"
}


object Libraries {
    // Compose
    val activityCompose = "androidx.activity:activity-compose:${Versions.compose}"
    val composeUi = "androidx.compose.ui:ui:~${Versions.compose}"
    val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    // Material 3
    val material3 = "androidx.compose.material3:material3:${Versions.material3}"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"


    // Lifecycle
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val viewModelSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    val lifecycleRuntimeCompose =
        "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle}"

    // Coroutines
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    // Hilt
    val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    val hiltWork = "androidx.hilt:hilt-work:${Versions.hiltWork}"
    val hiltDaggerCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
    val androidxHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltWork}"

    // Coil
    val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    // logcat
    val logcat = "com.squareup.logcat:logcat:${Versions.logcat}"

    // Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    // Moshi
    val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    // Okhttp3
    val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp3}"
    val loggingIntercepter = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3}"

    // Room
    val room = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // WorkManager
    val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
}

object TestLibraries {
    val junit4 = "unit:junit:${Versions.jUnit4}"

    val composeUi = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    val composeManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
}
