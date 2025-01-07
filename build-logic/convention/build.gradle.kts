import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "kr.co.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.android.gradlePlugin)
    implementation(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("SeeDocsApplicationCompose") {
            id = "seedocs.application.compose"
            implementationClass = "SeeDocsComposeConventionPlugin"
        }
        register("SeeDocsApplication") {
            id = "seedocs.application"
            implementationClass = "SeeDocsConventionPlugin"
        }
        register("SeeDocsLibraryCompose") {
            id = "seedocs.library.compose"
            implementationClass = "SeeDocsLibraryComposeConventionPlugin"
        }
        register("SeeDocsLibrary") {
            id = "seedocs.library"
            implementationClass = "SeeDocsLibraryConventionPlugin"
        }
        register("SeeDocsFeature") {
            id = "seedocs.feature"
            implementationClass = "SeeDocsFeatureConventionPlugin"
        }
    }
}