import kr.co.convention.configureAndroidCompose
import kr.co.convention.libraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class SeeDocsLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            configureAndroidCompose(libraryExtension)
        }
    }
}