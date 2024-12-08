import kr.co.convention.Local
import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
    alias(libs.plugins.seedocs.hilt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.room)
}

ksp {
    arg("room.generateKotlin", "true")
}

room {
    schemaDirectory("$projectDir/schemas")
}

android {
    setNamespace("core.database")

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.model)

    Local()
}