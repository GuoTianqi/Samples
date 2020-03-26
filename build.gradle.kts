group = "com.gtq.faith"
version = "1.0-SNAPSHOT"


buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.71"))
    }
}

plugins {
    java
    kotlin("jvm") version "1.3.71"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
}