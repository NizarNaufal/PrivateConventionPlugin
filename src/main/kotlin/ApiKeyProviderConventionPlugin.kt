import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.util.Properties

class ApiKeyProviderConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val localProperties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists() && localPropertiesFile.isFile) {
            localPropertiesFile.inputStream().use { input ->
                localProperties.load(input)
            }
        }

        val devApiKey = checkNotNull(
            localProperties.getProperty("dev.apikey") ?: System.getenv("DEV_API_KEY")
        )

        val stageApiKey = checkNotNull(
            localProperties.getProperty("stage.apikey") ?: System.getenv("STAGE_API_KEY")
        )

        val prodApiKey = checkNotNull(
            localProperties.getProperty("prod.apikey") ?: System.getenv("API_KEY")
        )

        extensions.configure<BaseAppModuleExtension> {
            defaultConfig.buildConfigField("String", "DEV_API_KEY", "\"$devApiKey\"")
            defaultConfig.buildConfigField("String", "STAGE_API_KEY", "\"$stageApiKey\"")
            defaultConfig.buildConfigField("String", "PROD_API_KEY", "\"$prodApiKey\"")
        }
    }
}