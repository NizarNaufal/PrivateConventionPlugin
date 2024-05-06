package id.technzr.configuration

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = ConventionVersion.androidxComposeCompiler
        }

        dependencies {
            add("implementation", platform(ConventionDependency.androidxComposeBom))
            ConventionBundle.composeDependencies.forEach {
                add("implementation", it)
            }
            add("androidTestImplementation", platform(ConventionDependency.androidxComposeBom))
        }
    }
}