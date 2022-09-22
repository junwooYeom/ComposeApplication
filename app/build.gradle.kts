plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.capri.composeapplication"
    compileSdk = libs.versions.compilesdk.get().toInt()

    defaultConfig {
        applicationId = "com.capri.composeapplication"
        minSdk = libs.versions.minsdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled =  false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":network"))
    implementation(project(":domain"))
    implementation(project(":database"))
    implementation(project(":ui-components"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.bundles.compose)
    implementation(libs.coroutines)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    implementation(libs.lifecycle.viewmodel.compose)

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.0-beta02")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.0-beta02")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0-beta02")
}
