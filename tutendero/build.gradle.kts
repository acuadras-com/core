plugins {
	kotlin("jvm") version "1.3.61" apply false
}

subprojects {
	apply {
		plugin("org.jetbrains.kotlin.jvm")
	}

	group = "com.tutendero"
	version = "1.0"

	repositories {
		mavenCentral()
		jcenter()
	}

	val implementation by configurations

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-aop:2.2.5.RELEASE")
	}
}
