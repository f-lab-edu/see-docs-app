import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.model)
    implementation(projects.core.database)
}