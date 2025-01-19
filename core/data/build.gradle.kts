import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
}

android {
    setNamespace("core.data")
}

dependencies {
    api(projects.core.model)
    implementation(projects.core.common)
    implementation(projects.core.database)

    testImplementation(projects.core.testing)
}