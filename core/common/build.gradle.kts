import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
}

setNamespace("core.common")

android {
    buildFeatures {
        buildConfig = true
    }
}