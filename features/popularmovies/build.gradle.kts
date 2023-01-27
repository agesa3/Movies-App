plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.koltinParcelize)
    id(BuildPlugins.kotlinKapt)
}

android {
    namespace = "com.beatrice.popularmovies"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        kotlinCompilerExtensionVersion = "1.4.0-alpha02"
    }
}

dependencies {
    implementation(project(BuildModules.Domain))
    implementation(project(BuildModules.Data))

//    val composeVersion = "1.4.0-alpha03"
//    implementation("androidx.core:core-ktx:1.9.0")
//    implementation("androidx.activity:activity-compose:1.6.1")
    implementation(Libraries.composeUi)
    implementation(Libraries.composePreview)

    // Material 3
    implementation(Libraries.material3)

    // Constraint Layout
    implementation(Libraries.constraintLayout)

    // Navigation
//    val navVersion = "2.5.3"
    implementation(Libraries.composeNavigation)

    // Lifecycle
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.viewModelSavedState)
    implementation(Libraries.lifecycleRuntimeCompose)

    // Hilt
    implementation(Libraries.daggerHilt)
    kapt(Libraries.hiltDaggerCompiler)
    implementation(Libraries.hiltNavigationCompose)
    implementation(Libraries.hiltWork)
    kapt(Libraries.androidxHiltCompiler)

    // logcat
    implementation(Libraries.logcat)

    // Coil
    implementation(Libraries.coil)

    // Coroutines
    implementation(Libraries.coroutines)
}

kapt {
    correctErrorTypes = true
}