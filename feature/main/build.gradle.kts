import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.feature)
    alias(libs.plugins.seedocs.library.compose)
}

setNamespace("feature.main")

dependencies {
    implementation(projects.feature.explore)
    implementation(projects.feature.recent)
    implementation(projects.feature.bookmark)
}