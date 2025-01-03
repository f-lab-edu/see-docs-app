import kr.co.convention.setNamespace

plugins {
    alias(libs.plugins.seedocs.feature)
    alias(libs.plugins.seedocs.library.compose)
}

setNamespace("feature.pdf")

dependencies {
    implementation("net.engawapg.lib:zoomable:1.6.2")
}