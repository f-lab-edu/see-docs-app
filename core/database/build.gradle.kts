import kr.co.convention.Local
import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
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

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources {
            excludes.add("META-INF/LICENSE.md")
            excludes.add("META-INF/LICENSE-notice.md")
        }
    }
}

dependencies {
    implementation(projects.core.common)

    Local()

    testImplementation(libs.robolectric)
    testImplementation(projects.core.testing)
    testImplementation(libs.room.test)
    testImplementation("androidx.arch.core:core-testing:2.1.0")
}