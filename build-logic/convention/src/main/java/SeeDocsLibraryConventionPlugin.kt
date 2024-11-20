import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import kr.co.convention.androidTestImplementations
import kr.co.convention.configureKotlinAndroid
import kr.co.convention.disableUnnecessaryAndroidTests
import kr.co.convention.implementations
import kr.co.convention.libs
import kr.co.convention.testImplementations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class SeeDocsLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                resourcePrefix = path.split("""\W""".toRegex()).drop(1).distinct().joinToString(separator = "_").lowercase() + "_"
            }

            extensions.configure<LibraryAndroidComponentsExtension> {
                disableUnnecessaryAndroidTests(target)
            }

            dependencies {
                implementations(
                    libs.timber
                )
                testImplementations(
                    kotlin("test")
                )
                androidTestImplementations(
                    kotlin("test")
                )
            }
        }
    }
}