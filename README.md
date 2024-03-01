
First we need to look into this for setup if not we are going to face the below issues
https://dagger.dev/hilt/gradle-setup.html


Issues:

id("kotlin-kapt") instead we should use id("org.jetbrains.kotlin.kapt") if not kapt("androidx.hilt:hilt-compiler:{latest-version}") this won't compile.

> 'compileDebugJavaWithJavac' task (current target is 1.8) and 'kaptGenerateStubsDebugKotlin' task (current target is 17) 
jvm target compatibility should be set to the same Java version.

Issue:
--------------------------------------------------------
compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1.8
        targetCompatibility = JavaVersion.VERSION_1.8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

Resolved:
---------------------------------------------------------
compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
	

For new version of Android studio we no need to create classpath in project level build.gradle file 
Instead we need to add id to plugin

For example:
buildscript {
    dependencies {
        classpath "com.google.dagger:hilt-android-gradle-plugin:2.51"
    }
}

But this doesn't work in newer version of Android Studio
Instead we should add in the plugin below:

plugins {
    id("com.google.dagger.hilt.android") version "2.51" apply false
}
and then add id("com.google.dagger.hilt.android") in the app level build.gradle file
