import kr.co.convention.configureAndroidCompose
import kr.co.convention.applicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class SeeDocsComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            configureAndroidCompose(applicationExtension)
        }
    }
}