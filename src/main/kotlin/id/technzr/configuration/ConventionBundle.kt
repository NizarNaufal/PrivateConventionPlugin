package id.technzr.configuration

object ConventionBundle {

    // Android Compose
    val composeDependencies = listOf(
        ConventionDependency.androidxComposeRuntime,
        ConventionDependency.androidXLifecycleViewModelCompose,
        ConventionDependency.androidXComposeActivity,
        ConventionDependency.androidXComposeUi,
        ConventionDependency.androidXComposeUiTooling,
        ConventionDependency.androidXComposeUiToolingPreview,
        ConventionDependency.androidXComposeUiUtil,
        ConventionDependency.androidXComposeConstraint,
        ConventionDependency.androidXComposeNavigation,
        ConventionDependency.androidXComposeMaterial,
    )

    // desugar
    val desugarDependencies = listOf(
        ConventionDependency.desugarJdkLibs
    )

    // Android Room
    val roomDependencies = listOf(
        ConventionDependency.androidxRoomKtx,
        ConventionDependency.androidxRoomRuntime
    )

    // Okhttp
    val okhttpDependencies = listOf(
        ConventionDependency.okhttp, ConventionDependency.okhttpLoggingInterceptor
    )

    // Koin
    val koinDependencies = listOf(
        ConventionDependency.koinCompose, ConventionDependency.koinNavigationCompose
    )

    // Retrofit
    val retrofitDependencies = listOf(
        ConventionDependency.retrofit,
        ConventionDependency.retrofitGsonConverter,
        ConventionDependency.retrofitCoroutinesAdapter,
        ConventionDependency.gson
    )
}
