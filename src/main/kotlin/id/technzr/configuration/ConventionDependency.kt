package id.technzr.configuration

object ConventionDependency {
    // Android Compose
    const val androidxComposeBom =
        "androidx.compose:compose-bom:${ConventionVersion.androidxComposeBom}"
    const val androidxComposeRuntime = "androidx.compose.runtime:runtime"

    // Android Room
    const val androidxRoomKtx = "androidx.room:room-ktx:${ConventionVersion.androidxRoom}"
    const val androidxRoomCompiler = "androidx.room:room-compiler:${ConventionVersion.androidxRoom}"
    const val androidxRoomRuntime =
        "androidx.room:room-runtime:${ConventionVersion.androidxRoom}"

    // Detekt Lint
    const val detektGradlePlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${ConventionVersion.detekt}"
    const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:${ConventionVersion.detekt}"

    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${ConventionVersion.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${ConventionVersion.hilt}"

    // Okhttp
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${ConventionVersion.okhttpBom}"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${ConventionVersion.retrofit}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${ConventionVersion.gson}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${ConventionVersion.retrofitCoroutinesAdapter}"

}