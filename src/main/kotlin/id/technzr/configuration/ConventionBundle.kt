package id.technzr.configuration

object ConventionBundle {
    // Android Compose
    val composeDependencies = listOf(
        ConventionDependency.androidxComposeRuntime
    )

    // Android Room
    val roomDependencies = listOf(
        ConventionDependency.androidxRoomRuntime,
        ConventionDependency.androidxRoomCompiler
    )

    // Okhttp
    val okhttpDependencies = listOf(
        ConventionDependency.okhttp,
        ConventionDependency.okhttpLoggingInterceptor
    )

    // Retrofit
    val retrofitDependencies = listOf(
        ConventionDependency.retrofit,
        ConventionDependency.retrofitGsonConverter,
        ConventionDependency.retrofitCoroutinesAdapter
    )
}