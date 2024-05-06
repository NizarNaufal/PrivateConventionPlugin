import id.technzr.configuration.ConventionBundle
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidKoinConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {

            dependencies {
                ConventionBundle.koinDependencies.forEach {
                    add("implementation", it)
                }
            }
        }
    }
}
