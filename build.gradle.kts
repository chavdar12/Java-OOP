subprojects {
    if (!file("src").isDirectory) return@subprojects

    apply(plugin = "java")

    repositories { mavenCentral() }

    // Most modules are plain IntelliJ modules with sources directly under src/
    if (!file("src/main/java").isDirectory) {
        configure<SourceSetContainer> {
            named("main") { java.setSrcDirs(listOf("src")) }
            named("test") { java.setSrcDirs(listOf("test")) }
        }
    }

    tasks.withType<JavaCompile>().configureEach {
        options.release = 17
        options.encoding = "UTF-8"
    }

    dependencies {
        "testImplementation"("junit:junit:4.13.2")
        "testImplementation"("org.mockito:mockito-core:5.20.0")
    }

    tasks.withType<Test>().configureEach { useJUnit() }
}
