package kr.co.convention

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "${project.groupId}.$name"
    }
}