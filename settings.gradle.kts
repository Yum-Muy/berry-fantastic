val slug: String by settings
rootProject.name = slug

pluginManagement {
	repositories {
		maven("https://maven.fabricmc.net/")
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	repositories {
		// Modrinth Maven - see: https://support.modrinth.com/en/articles/8801191-modrinth-maven
		// Mods may be pulled from here will this format: "maven.modrinth:<slug>:<version>"
		exclusiveContent {
			forRepositories(maven("https://api.modrinth.com/maven")).filter {
				includeGroup("maven.modrinth")
			}
		}
	}
}
