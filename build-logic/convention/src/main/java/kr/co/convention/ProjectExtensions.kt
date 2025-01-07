package kr.co.convention

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the


internal val Project.libs get() = the<LibrariesForLibs>()

fun Project.App() {
    project.dependencies {
        implementations(
            libs.androidx.core.splashscreen,
            libs.androidx.constraintlayout,
            libs.androidx.lifecycle.livedata,
            libs.androidx.lifecycle.viewmodel,
            libs.androidx.navigation.ui,
            libs.androidx.navigation.fragment,
            libs.coil,
            libs.timber,
            libs.compose.activity,
            libs.compose.lifecycle.runtime,
            libs.compose.navigation,
            libs.compose.hilt.navigation,
        )

        testImplementations(
            libs.junit
        )

        androidTestImplementations(
            libs.androidx.junit,
            libs.androidx.espresso.core
        )
    }
}

fun Project.Local() {
    project.dependencies {
        implementations(
            libs.bundles.rooms,
            libs.datastore.preferences
        )

        ksp(libs.room.compiler)
    }
}