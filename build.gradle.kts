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
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jersey")
	implementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.data:spring-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.projectlombok:lombok")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	testImplementation("io.rest-assured:rest-assured")
	testImplementation("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("mysql:mysql-connector-java:8.0.19")
	annotationProcessor("org.projectlombok:lombok")

	implementation("org.springframework.boot:spring-boot-starter-undertow")
//	camel
	implementation("org.apache.camel.springboot:camel-servlet-starter:3.17.0")
	implementation("org.apache.camel.springboot:camel-jackson-starter:3.17.0")
	implementation("org.apache.camel.springboot:camel-http-starter:3.17.0")
	implementation("org.apache.camel.springboot:camel-jackson-starter:3.17.0")
	implementation("org.apache.camel.springboot:camel-swagger-java-starter:3.17.0")
	implementation("org.apache.camel.springboot:camel-spring-boot-starter:3.17.0")
	implementation("org.apache.camel:camel-jaxb:3.17.0")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("com.zoomint.encourage:encourage-data-model:20.2.6-SNAPSHOT")
	// https://mvnrepository.com/artifact/org.restlet.jee/org.restlet
	implementation("org.restlet.jee:org.restlet:3.0-M1")
// https://mvnrepository.com/artifact/org.springframework.hateoas/spring-hateoas
	implementation("org.springframework.hateoas:spring-hateoas:1.5.1")
// https://mvnrepository.com/artifact/org.springframework.data/spring-data-rest-core
	implementation("org.springframework.data:spring-data-rest-core:3.6.4")

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
