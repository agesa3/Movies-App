
plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerHilt)
    id(BuildPlugins.klint)
}

android {
    namespace = "com.beatrice.sync"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(project(BuildModules.Domain))

    // WorkManager
    implementation(Libraries.workManager)

    // Hilt
    implementation(Libraries.daggerHilt)
    kapt(Libraries.hiltDaggerCompiler)
    implementation(Libraries.hiltWork)
    kapt(Libraries.androidxHiltCompiler)

    // Coroutines
    implementation(Libraries.coroutines)
}
kapt {
    correctErrorTypes = true
}
