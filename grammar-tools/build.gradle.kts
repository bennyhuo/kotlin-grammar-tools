plugins {
    kotlin("jvm")
    antlr
    id("com.vanniktech.maven.publish") version "0.18.0"
}

dependencies {
    antlr("org.antlr:antlr4:4.9.3")
    testImplementation("junit:junit:4.12")
}

tasks.compileKotlin {
    dependsOn("generateGrammarSource")
}

tasks.withType<AntlrTask> {
    val targetPackageName = "org.jetbrains.kotlin.spec.grammar"
    outputDirectory =
        File("${projectDir}/src/main/java/${targetPackageName.replace('.', '/')}").also {
            it.mkdirs()
        }

    arguments.add("-package")
    arguments.add(targetPackageName)
}