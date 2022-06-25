plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.google.cloud.tools.jib") version "3.1.4"
	id("com.avast.gradle.docker-compose") version "0.14.3"
	id("org.unbroken-dome.helm") version "1.7.0" apply true
	id("org.unbroken-dome.helm-releases") version "1.7.0" apply true
	id("org.unbroken-dome.helm-publish") version "1.7.0" apply true
	id("java")
}

repositories {
	maven { url = uri("https://artifactory.zoomint.com/artifactory/zoom-ci-release") }
	maven { url = uri("https://artifactory.zoomint.com/artifactory/ci-libs-release") }
	maven { url = uri("https://artifactory.zoomint.com:80/artifactory/remote-repos") }
	maven { url = uri("https://artifactory.zoomint.com/artifactory/zoom-dev-release") }
	maven { url = uri("https://artifactory.zoomint.com/artifactory/zoom-dev-snapshot") }
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator:2.6.7")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.7")
	implementation("org.springframework.boot:spring-boot-starter-data-rest:2.6.7")
	implementation("org.springframework.boot:spring-boot-starter-jersey:2.6.7")
	implementation("org.springframework.boot:spring-boot-starter-test:2.6.7")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.7")
	implementation("org.springframework.boot:spring-boot-starter-aop:2.6.7")
	implementation("org.springframework.data:spring-data-rest-core:3.6.4")
	implementation("org.springframework.data:spring-data-commons:2.6.4")
	implementation("org.springframework:spring-webmvc:5.3.19")
	implementation("org.springframework.hateoas:spring-hateoas:1.4.2")
	implementation("org.springframework.data:spring-data-jpa:2.6.4")
	implementation("jakarta.persistence:jakarta.persistence-api:2.2.3")
	// https://mvnrepository.com/artifact/org.eclipse.persistence/org.eclipse.persistence.jpa
//	implementation("org.eclipse.persistence:org.eclipse.persistence.jpa:2.7.4")
	// https://mvnrepository.com/artifact/com.google.common/google-collect
	// https://mvnrepository.com/artifact/com.google.guava/guava
	implementation("com.google.guava:guava:30.1.1-jre")
	implementation("org.postgresql:postgresql:")











	implementation("org.springframework.boot:spring-boot-devtools")
//	implementation("org.springframework.data:spring-data-jpa:2.6.7")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.projectlombok:lombok")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	testImplementation("io.rest-assured:rest-assured")
	testImplementation("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("mysql:mysql-connector-java:8.0.19")
	annotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test>() {
	useJUnitPlatform()
}

dockerCompose {
	useComposeFiles = listOf("docker-compose.yaml")
}

tasks.register("devRun") {
	dependsOn(
		tasks.getByPath("composeUp"),
		tasks.getByPath("bootRun")
	)
	tasks.getByPath("bootRun").mustRunAfter(tasks.getByPath("composeUp"))
}
