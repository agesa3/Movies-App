pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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
