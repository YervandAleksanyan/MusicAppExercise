plugins {
    id(Dependencies.Plugins.applicationPlugin)
    id(Dependencies.Plugins.kotlinPlugin)
    id(Dependencies.Plugins.kotlinKapt)
    id(Dependencies.Plugins.kotlinParcelize)
    id(Dependencies.Plugins.realmAndroid)

}


android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://rss.applemarketingtools.com/api/v2/\""
            )
        }
        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://rss.applemarketingtools.com/api/v2/\""
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.composeVersion
    }
    packagingOptions {
        resources {
            excludes += Config.excludes
        }
    }
}

dependencies {

    implementation(Dependencies.Android.ktxCore)
    implementation(Dependencies.Android.runtimeLifecycle)
    testImplementation(Dependencies.Android.jUnit)
    androidTestImplementation(Dependencies.Android.jUnitTest)
    androidTestImplementation(Dependencies.Android.espresso)

    //Compose
    implementation(Dependencies.Compose.activityCompose)
    androidTestImplementation(Dependencies.Compose.composeJUnit)
    debugImplementation(Dependencies.Compose.composeUITooling)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.composeFoundation)
    implementation(Dependencies.Compose.composeMaterialIcons)
    implementation(Dependencies.Compose.composeMaterialIconsExtended)
    implementation(Dependencies.Compose.composeConstraintLayout)
    implementation(Dependencies.Compose.composeLiveData)
    implementation(Dependencies.Compose.composeViewModel)
    implementation(Dependencies.Compose.swipeRefresh)
    implementation(Dependencies.Compose.composeMaterial3)

    // Navigation Compose
    implementation(Dependencies.Compose.composeNavigation)
    implementation(Dependencies.Compose.accompanistPermissions)
    implementation(Dependencies.Compose.accompanist)
    implementation(Dependencies.Compose.accompanistAnimationNavigation)

    // Permissions
    implementation(Dependencies.Compose.permissions)

    // Realm
    implementation(Dependencies.Realm.realm)

    // Koin main features for Android
    implementation(Dependencies.Koin.koinAndroid)
    implementation(Dependencies.Koin.koinCompose)
    implementation(Dependencies.Koin.koinCore)

    // Coroutines
    implementation(Dependencies.Coroutines.coroutinesAndroid)
    implementation(Dependencies.Coroutines.coroutinesCore)

    //Timber
    implementation(Dependencies.LogTimber.logTimber)

    // Orbit
    implementation(Dependencies.Orbit.orbitCore)
    implementation(Dependencies.Orbit.orbitViewModel)
    implementation(Dependencies.Orbit.orbitCompose)
    testImplementation(Dependencies.Orbit.orbitTestImplementation)


    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.gsonConverter)
    implementation(Dependencies.Retrofit.adapterRxjava3)

    // okHttpClient
    implementation(Dependencies.OkhttpClient.okhttpClient)
    implementation(Dependencies.OkhttpClient.loggingInterceptor)

    // Coil
    implementation(Dependencies.Coil.coil)
    // Lottie Animation
    implementation (Dependencies.LottieAnim.lottieAnim)


}