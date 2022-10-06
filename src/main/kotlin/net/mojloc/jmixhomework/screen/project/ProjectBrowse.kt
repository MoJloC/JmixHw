package net.mojloc.jmixhomework.screen.project

import io.jmix.ui.screen.*
import net.mojloc.jmixhomework.entity.Project

@UiController("Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
class ProjectBrowse : StandardLookup<Project>()