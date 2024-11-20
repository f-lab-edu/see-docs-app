import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
    alias(libs.plugins.seedocs.hilt)
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)
    implementation(projects.core.model)
}