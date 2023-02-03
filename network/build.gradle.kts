import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerHilt)
    id(BuildPlugins.klint)
}
val tmdbApiKey: String = gradleLocalProperties(rootDir).getProperty("TMDB_API_KEY")

android {
    namespace = "com.beatrice.network"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "TMDB_API_KEY", tmdbApiKey)

            val minifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "TMDB_API_KEY", tmdbApiKey)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Retrofit
    implementation(Libraries.retrofit)
    // Moshi
    implementation(Libraries.moshi)
    // OkHttp3
    implementation(Libraries.okHttp3)
    implementation(Libraries.loggingIntercepter)

    // Hilt
    implementation(Libraries.daggerHilt)
    kapt(Libraries.hiltDaggerCompiler)

    // logcat
    implementation(Libraries.logcat)

    // Testing
    testImplementation(TestLibraries.coroutine)
    testImplementation(TestLibraries.junit4)
}
kapt {
    correctErrorTypes = true
}
