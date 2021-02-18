package com.github.lukasniestroj.intellijddevplugin.services

import com.github.lukasniestroj.intellijddevplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
