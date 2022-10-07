package net.mojloc.jmixhomework.screen.project

import io.jmix.ui.UiComponents
import io.jmix.ui.component.CheckBox
import io.jmix.ui.component.Component
import io.jmix.ui.model.InstanceContainer
import io.jmix.ui.screen.*
import net.mojloc.jmixhomework.entity.Emplyee
import net.mojloc.jmixhomework.entity.Project
import org.springframework.beans.factory.annotation.Autowired

@UiController("Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
class ProjectEdit : StandardEditor<Project>() {
    @Autowired
    private lateinit var uiComponents: UiComponents

    @Autowired
    private lateinit var projectDc: InstanceContainer<Project>

    @Install(to = "emplyeesTable.isInProjectTeam", subject = "columnGenerator")
    private fun emplyeesTableIsInProjectTeamColumnGenerator(emplyee: Emplyee?): Component {
        var checkBox: CheckBox = uiComponents.create(CheckBox.NAME)
        checkBox.value = isEmployeeInProjectTeam(emplyee)

        checkBox.addValueChangeListener {
            run {
                if (isEmployeeInProjectTeam(emplyee) == true) {
                    println("True!")
                    emplyee?.projects?.remove(projectDc.item)
                } else {
                    println("False!")
                    emplyee?.projects?.add(projectDc.item)
                }
            }
        }

        return checkBox
    }

    private fun isEmployeeInProjectTeam (emplyee: Emplyee?): Boolean? {
        return emplyee?.projects?.contains(projectDc.item)
    }
}