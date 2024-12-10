import org.gradle.kotlin.dsl.attributes

plugins {
    java
    id("xyz.wagyourtail.unimined") version "1.3.11"
}

group = "com.idkidknow.ie1710neipatch"
version = "0.1.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
}

repositories {
    mavenCentral()
    maven("https://mcentral.firstdark.dev/releases")
    maven("https://repo.spongepowered.org/maven/")
    maven("https://jitpack.io")
    maven("https://cursemaven.com")
}

unimined.minecraft(sourceSets.main.get()) {
    version("1.7.10")
    mappings {
        searge()
        mcp("stable", "12-1.7.10")
    }

    minecraftForge {
        loader("10.13.4.1614-1.7.10")
        mixinConfig("mixins.ie1710neipatch.json")
    }

    defaultRemapJar = true
}

dependencies {
    "modImplementation"("com.github.LegacyModdingMC.UniMixins:unimixins-all-1.7.10:0.1.19:dev")
    "modImplementation"("curse.maven:immersive-engineering-231951:2299019")
}

tasks.jar {
    manifest {
        attributes(mapOf(
            "FMLCorePluginContainsFMLMod" to "true",
            "TweakClass" to "org.spongepowered.asm.launch.MixinTweaker",
            "ForceLoadAsMod" to "true",
        ))
    }
}
