package kr.co.convention

import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.implementations(vararg notations: Any) {
    notations.forEach { notation ->
        add("implementation", notation)
    }
}

internal fun DependencyHandlerScope.ksp(vararg notations: Any) {
    notations.forEach { notation ->
        add("ksp", notation)
    }
}

internal fun DependencyHandlerScope.debugImplementations(vararg notations: Any) {
    notations.forEach { notation ->
        add("debugImplementation", notation)
    }
}

internal fun DependencyHandlerScope.testImplementations(vararg notations: Any) {
    notations.forEach { notation ->
        add("testImplementation", notation)
    }
}

internal fun DependencyHandlerScope.androidTestImplementations(vararg notations: Any) {
    notations.forEach { notation ->
        add("androidTestImplementation", notation)
    }
}