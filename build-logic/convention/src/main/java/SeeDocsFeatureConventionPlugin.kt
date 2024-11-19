import kr.co.convention.implementations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class SeeDocsFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("seedocs.library")
                apply("seedocs.hilt")
            }

            dependencies {
                implementations(
                    project(":core:ui"),
                    project(":core:common"),
                    project(":core:domain"),
                    project(":core:navigation"),
                    project(":core:model"),
                )
            }
        }
    }
}