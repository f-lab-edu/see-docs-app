pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SeeDocs"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")

include(":core:ui")
include(":core:common")
include(":core:navigation")
include(":core:model")
include(":core:data")
include(":core:database")

include(":feature:main")
include(":feature:explore")
include(":feature:recent")
include(":feature:bookmark")
include(":feature:pdf")
include(":core:testing")
