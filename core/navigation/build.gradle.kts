import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
    alias(libs.plugins.kotlin.serialization)
}

setNamespace("core.navigation")

dependencies {
    implementation(libs.kotlinx.serialization.json)
}