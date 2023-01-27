pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    plugins {
        id("com.android.application") version "7.3.0"
        id("com.android.library") version "7.3.0"
        id("org.jetbrains.kotlin.android") version "1.7.21"
        id("com.google.dagger.hilt.android") version "2.44"
        id("org.jetbrains.kotlin.jvm") version "1.7.21"
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application", "com.android.library" -> useModule("com.android.tools.build:gradle:7.3.0")
            }
        }
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Movies App"
include(":app")
include(":database")
include(":core")
include(":network")
include(":data")
include(":features")
include(":features:popularmovies")
include(":domain")
include(":sync")
