package id.technzr.configuration


import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project

/**
 * Configures the detekt plugin.
 */
internal fun Project.configureDetekt(extension: DetektExtension) {
    extension.apply {
        parallel = true
        buildUponDefaultConfig = true
        autoCorrect = true
        source.setFrom(
            files(
                projectDir,
                "$rootDir/features/fulfillment",
                "$rootDir/features/sales",
                "$rootDir/features/order",
                "$rootDir/features/transports/driver",
            )
        )
        config.setFrom(files("$rootDir/build-logic/convention/detekt/detekt.yml"))
    }
}
