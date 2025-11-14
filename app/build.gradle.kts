plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    // Tambahkan KAPT untuk memproses anotasi Room
    id("org.jetbrains.kotlin.kapt")
    // Tambahkan Hilt Plugin
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "id.bytezilla.borutoapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "id.bytezilla.borutoapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.datastore.preferences)
    // Pastikan KAPT diletakkan sebelum implementation
    kapt(libs.androidx.room.compiler) // Untuk Room compiler

    // --- HILT COMPILERS ---
    kapt(libs.dagger.hilt.android.compiler) // Hilt compiler inti
    kapt(libs.androidx.hilt.compiler) // Hilt compiler AndroidX

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    // --- ROOM COMPONENTS ---
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
    // Tambahkan Paging Compose untuk UI
    implementation(libs.androidx.paging.compose)
    //hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    //material
    implementation(libs.androidx.material)
    // Horizontal Pager and Indicators - Accompanist
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}