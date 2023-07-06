import com.google.devtools.ksp.gradle.KspExtension
import id.technzr.configuration.ConventionBundle
import id.technzr.configuration.ConventionDependency
import id.technzr.configuration.RoomSchemaProvider
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import java.io.File

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply("com.google.devtools.ksp")

            extensions.configure<KspExtension> {
                arg(RoomSchemaProvider(File(projectDir, "schemas")))
            }

            dependencies {
                ConventionBundle.roomDependencies.forEach {
                    add("implementation", it)
                }
                add("ksp", ConventionDependency.androidxRoomCompiler)
            }
        }
    }
}