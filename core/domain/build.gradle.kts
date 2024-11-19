import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
    alias(libs.plugins.seedocs.hilt)
}

setNamespace("core.domain")

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.model)
}