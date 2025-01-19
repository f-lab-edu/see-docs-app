import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
}

setNamespace("core.data")

afterEvaluate {
    tasks.named("testDebugUnitTest", Test::class.java).configure {
        exclude("**/dummy/**")
    }

    tasks.named("testReleaseUnitTest", Test::class.java).configure {
        exclude("**/dummy/**")
    }
}

dependencies {
    api(projects.core.model)
    implementation(projects.core.common)
    implementation(projects.core.database)

    testImplementation(projects.core.testing)
}