import com.android.build.api.dsl.ApplicationExtension
import id.technzr.configuration.ConventionVersion
import id.technzr.configuration.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            extensions.configure<ApplicationExtension> {
                compileSdk = ConventionVersion.compileSdk.toInt()

                defaultConfig {
                    minSdk = ConventionVersion.minSdk.toInt()
                    targetSdk = ConventionVersion.targetSdk.toInt()
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                configureAndroidCompose(this)
            }

            extensions.configure<KaptExtension> {
                correctErrorTypes = true
            }
        }
    }
}