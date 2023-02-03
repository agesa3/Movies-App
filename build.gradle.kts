// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.androidApplication) apply false
    id(BuildPlugins.androidLibrary) apply false
    id(BuildPlugins.kotlinAndroid) version Versions.kotlinAndroid apply false
    id(BuildPlugins.daggerHilt) version Versions.daggerHilt apply false
    id(BuildPlugins.klint) version Versions.klint
}
