import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.feature)
    alias(libs.plugins.seedocs.library.compose)
}

setNamespace("feature.explore")
dependencies {
    implementation(libs.firebase.crashlytics.buildtools)
}
