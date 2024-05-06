import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "id.technzr.privateconventionplugin"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.1.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
    compileOnly("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.9.22-1.0.17")
    compileOnly("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.0")
    compileOnly("com.github.ben-manes:gradle-versions-plugin:0.46.0")
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "technzr.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "technzr.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "technzr.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "technzr.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "technzr.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "technzr.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("detekt") {
            id = "technzr.library.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("okhttp") {
            id = "technzr.okhttp.client"
            implementationClass = "OkhttpConventionPlugin"
        }
        register("retrofit") {
            id = "technzr.retrofit"
            implementationClass = "RetrofitConventionPlugin"
        }
        register("koinInject") {
            id = "technzr.koin.inject"
            implementationClass = "AndroidKoinConventionPlugin"
        }

        register("androidBenchmark") {
            id = "technzr.android.benchmark"
            implementationClass = "AndroidBenchmarkConventionPlugin"
        }

        register("gradleVersionChecker") {
            id = "technzr.gradle.version"
            implementationClass = "GradleVersionConventionPlugin"
        }

        register("androidSigningConfig") {
            id = "technzr.android.signingconfig"
            implementationClass = "AndroidSigningConfigConventionPlugin"
        }

        register("apiKeyProvider") {
            id = "technzr.apikey.provider"
            implementationClass = "ApiKeyProviderConventionPlugin"
        }
    }
}