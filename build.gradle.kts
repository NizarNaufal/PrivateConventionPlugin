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
    compileOnly("com.android.tools.build:gradle:8.0.0")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    compileOnly("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.8.20-1.0.11")
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
            id = "logee.library.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("okhttpRetrofit") {
            id = "technzr.okhttp.retrofit"
            implementationClass = "OkhttpRetrofitConventionPlugin"
        }
        register("gradleVersionChecker") {
            id = "technzr.gradle.version"
            implementationClass = "GradleVersionConventionPlugin"
        }
    }
}