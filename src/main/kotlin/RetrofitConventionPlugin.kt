import id.technzr.configuration.ConventionBundle
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RetrofitConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            dependencies {
                ConventionBundle.retrofitDependencies.forEach {
                    add("implementation", it)
                }
            }
        }
    }
}
