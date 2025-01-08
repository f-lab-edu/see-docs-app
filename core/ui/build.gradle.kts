import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
    alias(libs.plugins.seedocs.library.compose)
}

setNamespace("core.ui")

android {
    buildFeatures {
        buildConfig = true
    }
}