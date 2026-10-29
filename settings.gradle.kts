pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.architectury.dev/")
    }
}

rootProject.name = "chunky"

val myrpgPaperOnly = providers.gradleProperty("myrpgPaperOnly").orNull == "true"

val chunkyModules = sequenceOf(
    "nbt",
    "common",
    "paper",
    "folia",
    "bukkit",
    "fabric",
    "forge",
    "neoforge",
    "sponge"
).filter { !myrpgPaperOnly || it in setOf("nbt", "common", "paper", "folia", "bukkit") }

chunkyModules.forEach {
    include("${rootProject.name}-$it")
    project(":${rootProject.name}-$it").projectDir = file(it)
}
