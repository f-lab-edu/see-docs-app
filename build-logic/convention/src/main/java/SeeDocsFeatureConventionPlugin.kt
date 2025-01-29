import com.android.build.gradle.LibraryExtension
import kr.co.convention.androidTestImplementations
import kr.co.convention.debugImplementations
import kr.co.convention.implementations
import kr.co.convention.libs
import kr.co.convention.testImplementations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class SeeDocsFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("seedocs.library")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies {
                implementations(
                    project(":core:ui"),
                    project(":core:common"),
                    project(":core:data"),
                    project(":core:navigation"),
                    project(":core:model"),
                    libs.koin.compose
                )

                testImplementations(
                    project(":core:testing")
                )

                androidTestImplementations(
                    libs.androidx.junit,
                    libs.androidx.junit.compose,
                    libs.androidx.runner,
                    libs.androidx.espresso.core,
                )

                debugImplementations(libs.androidx.compose.manifest)
            }
        }
    }
}