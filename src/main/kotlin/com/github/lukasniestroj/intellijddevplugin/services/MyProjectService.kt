package com.github.lukasniestroj.intellijddevtools.services

import com.github.lukasniestroj.intellijddevtools.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
