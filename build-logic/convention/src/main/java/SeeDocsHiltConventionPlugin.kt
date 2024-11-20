import kr.co.convention.implementations
import kr.co.convention.ksp
import kr.co.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SeeDocsHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("com.google.devtools.ksp")
                apply("dagger.hilt.android.plugin")
            }

            dependencies {
                implementations(
                    libs.hilt.android
                )
                ksp(
                    libs.hilt.compiler
                )
            }
        }
    }
}