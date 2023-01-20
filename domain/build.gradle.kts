import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("kotlin")
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    // Coroutines
    val coroutineVersion = "1.6.4"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")

}