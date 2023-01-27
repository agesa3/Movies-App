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
include(
    ":app",
    ":database",
    ":network",
    ":data",
    ":features:popularmovies",
    ":domain",
    ":sync"
)
rootProject.name = "Movies App"

