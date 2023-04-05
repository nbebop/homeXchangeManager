plugins {
    java
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.20"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // MySQL
    implementation("mysql:mysql-connector-java:8.0.26")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // H2
    implementation("com.h2database:h2")

    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
