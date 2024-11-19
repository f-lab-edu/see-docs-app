import com.android.build.api.dsl.ApplicationExtension
import kr.co.convention.configureKotlinAndroid
import kr.co.convention.groupId
import kr.co.convention.targetSdk
import kr.co.convention.versionCode
import kr.co.convention.versionName
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SeeDocsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = targetSdk

                namespace = project.groupId

                defaultConfig {
                    applicationId = project.groupId
                    versionCode = project.versionCode
                    versionName = project.versionName

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }
            }
        }
    }
}