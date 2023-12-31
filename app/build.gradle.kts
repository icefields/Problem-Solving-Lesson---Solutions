plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
//    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

val composeVersion = rootProject.extra.get("compose_version") as String

android {
    namespace = "org.hungrytessy.interviewquestions"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.hungrytessy.interviewquestions"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    }
    compileOptions {
        //isCoreLibraryDesugaringEnabled = true
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
        kotlinCompilerExtensionVersion = composeVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Compose Nav Destinations
    implementation("io.github.raamcosta.compose-destinations:core:1.1.2-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.1.2-beta")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.compose.material:material-icons-extended:1.5.4")

//    //Dagger - Hilt
//    implementation("com.google.dagger:hilt-android:2.48")
//    kapt("com.google.dagger:hilt-android-compiler:2.48")
//    kapt("androidx.hilt:hilt-compiler:1.1.0")
//    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
//    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//
//    // Retrofit
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
//    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
//    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
//
//    // Room
//    implementation("androidx.room:room-runtime:2.6.1")
//    ksp("androidx.room:room-compiler:2.6.1")
//
//    // Kotlin Extensions and Coroutines support for Room
//    implementation("androidx.room:room-ktx:2.6.1")
}