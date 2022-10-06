package net.mojloc.jmixhomework.screen.project

import io.jmix.ui.screen.*
import net.mojloc.jmixhomework.entity.Project

@UiController("Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
class ProjectEdit : StandardEditor<Project>()