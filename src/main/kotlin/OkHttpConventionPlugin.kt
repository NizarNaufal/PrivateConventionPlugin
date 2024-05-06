import id.technzr.configuration.ConventionBundle
import id.technzr.configuration.ConventionDependency
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class OkhttpConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            dependencies {
                add("implementation", platform(ConventionDependency.okhttpBom))
                ConventionBundle.okhttpDependencies.forEach {
                    add("implementation", it)
                }
            }
        }
    }
}
