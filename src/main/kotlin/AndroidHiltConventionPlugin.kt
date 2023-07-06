import id.technzr.configuration.ConventionDependency
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                "implementation"(ConventionDependency.hiltAndroid)
                "kapt"(ConventionDependency.hiltCompiler)
                "kaptAndroidTest"(ConventionDependency.hiltCompiler)
            }
        }
    }
}