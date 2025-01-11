import kr.co.convention.implementations
import kr.co.convention.libs
import kr.co.convention.testImplementations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class SeeDocsFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("seedocs.library")
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
            }
        }
    }
}