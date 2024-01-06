plugins {
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenCentral()
}
group = "com.rekindle.book.store"
version = "1.0.0"
dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("io.strikt:strikt-core:0.34.1")
    implementation("io.strikt:strikt-jvm:0.34.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
