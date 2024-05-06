package id.technzr.configuration

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureKotlinAndroid(commonExtension: CommonExtension<*, *, *, *, *>) =
    with(commonExtension) {
        compileSdk = ConventionVersion.compileSdk.toInt()

        defaultConfig {
            minSdk = ConventionVersion.minSdk.toInt()
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
        }

        configureKotlinJvm()

        dependencies.add("coreLibraryDesugaring", ConventionBundle.desugarDependencies)
    }
