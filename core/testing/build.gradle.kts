import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.library)
}

setNamespace("core.testing")

dependencies {
    api(libs.mockk)
    api(libs.kotlinx.coroutines.test)
    api(libs.mockk.android)
    api(libs.koin.test)
    api(libs.koin.junit)
    api(projects.core.data)
}