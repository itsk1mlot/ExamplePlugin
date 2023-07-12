import org.gradle.configurationcache.extensions.capitalized

plugins {
    kotlin("jvm") version "1.8.21"
}

group = "io.github.lucystudio.example"
version = "1.0"

val testServerDir: String by project // 테스트서버 주소 불러오기(gradle.properties에서)
val pluginName: String = rootProject.name.capitalized() // 플러그인 이름 불러오기

repositories {
    mavenCentral()
    // MINECRAFT REPOSISTORIES
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // OTHER DEPENDENCIES
    testImplementation(kotlin("test"))

    // MINECRAFT DEPENDENCIES
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    // JAVA DEPENDENCIES
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

// BUILD TOOLS ------------------------
task("fatJar", type = Jar::class) {
    dependsOn(tasks.jar)
    archiveBaseName.set(pluginName)
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

task("testJar") {
    val fatJar = tasks.getByName("fatJar") as Jar
    dependsOn(fatJar)

    if(!fatJar.archiveFile.get().asFile.exists()) return@task
    val destFile = File("$testServerDir/plugins/")
    doLast {
        copy {
            from(fatJar.archiveFile.get().asFile.absolutePath)
            into(destFile.absolutePath)
        }
    }
}