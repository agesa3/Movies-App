object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val daggerHilt = "com.google.dagger.hilt.android"
    const val kotlinKapt = "kotlin-kapt"
    const val koltinParcelize = "kotlin-parcelize"
    const val klint = "org.jlleitschuh.gradle.ktlint"
    const val detekt = "io.gitlab.arturbosch.detekt"
}

object Versions {
    const val compose = "1.4.0-alpha03"
    const val material3 = "1.1.0-alpha03" // 5
    const val constraintLayout = "1.0.1"
    const val navigation = "2.5.3"
    const val lifecycle = "2.6.0-alpha03"
    const val coroutine = "1.6.4"
    const val daggerHilt = "2.44.2"
    const val hiltCompiler = "1.0.0"
    const val hiltNavigationCompose = "1.0.0"
    const val hiltWork = "1.0.0"
    const val logcat = "0.1"
    const val coil = "2.2.2"
    const val jUnit4 = "4.13.2"

    // Retrofit
    const val retrofit = "2.9.0"

    // OkHttp3
    const val okHttp3 = "5.0.0-alpha.10"

    // Room
    const val room = "2.4.3"

    // WorkManager
    const val workManager = "2.7.1"

    // Gradle Plugins
    const val kotlinAndroid = "1.7.21"
    const val kotlinJvm = "1.7.21"
    const val klint = "11.1.0"
    const val detekt = "1.22.0"
}


object Libraries {
    // Compose
    const val activityCompose = "androidx.activity:activity-compose:${Versions.compose}"
    const val composeUi = "androidx.compose.ui:ui:~${Versions.compose}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    // Material 3
    const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"


    // Lifecycle
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModelSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    const val lifecycleRuntimeCompose =
        "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle}"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    // Hilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    const val hiltWork = "androidx.hilt:hilt-work:${Versions.hiltWork}"
    const val hiltDaggerCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
    const val androidxHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltWork}"

    // Coil
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    // logcat
    const val logcat = "com.squareup.logcat:logcat:${Versions.logcat}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    // Moshi
    const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    // Okhttp3
    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp3}"
    const val loggingIntercepter = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3}"

    // Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // WorkManager
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
}

object TestLibraries {
    const val junit4 = "junit:junit:${Versions.jUnit4}"

    const val composeUi = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
}
