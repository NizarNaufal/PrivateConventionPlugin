package id.technzr.privateconventionplugin

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