package id.technzr.configuration

import org.gradle.api.artifacts.VersionCatalog

internal fun VersionCatalog.generateVersionName(): String {
    val major = findVersion("appVersionMajor").get().requiredVersion.toInt()
    val minor = findVersion("appVersionMinor").get().requiredVersion.toInt()
    val patch = findVersion("appVersionPatch").get().requiredVersion.toInt()

    return "$major.$minor.$patch"
}

internal fun VersionCatalog.generateVersionCode(): Int {
    val major = findVersion("appVersionMajor").get().requiredVersion.toInt()
    val minor = findVersion("appVersionMinor").get().requiredVersion.toInt()
    val patch = findVersion("appVersionPatch").get().requiredVersion.toInt()

    // TODO: temporary calculation
    return major * 100000 + minor * 10000 + patch * 1000 + 1
}