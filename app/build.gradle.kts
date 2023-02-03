plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerHilt)
    id(BuildPlugins.koltinParcelize)
    id(BuildPlugins.klint)
}

android {
    namespace = "com.beatrice.moviesapp"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        applicationId = ConfigurationData.applicationId
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk
        versionCode = ConfigurationData.versionCode
        versionName = ConfigurationData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0-alpha02"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(mapOf("path" to ":features:popularmovies")))
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":sync")))

    // Compose
    implementation(Libraries.activityCompose)
    implementation(Libraries.composeUi)
    implementation(Libraries.coroutines)

    // Material 3
    implementation(Libraries.material3)
    implementation(Libraries.composeNavigation)

    // Coroutines
    implementation(Libraries.coroutines)

    // logcat
    implementation(Libraries.logcat)

    // Hilt
    implementation(Libraries.daggerHilt)
    kapt(Libraries.hiltDaggerCompiler)
    implementation(Libraries.hiltNavigationCompose)
    implementation(Libraries.hiltWork)
    kapt(Libraries.androidxHiltCompiler)
}

kapt {
    correctErrorTypes = true
}
hilt {
    enableAggregatingTask = true
}
