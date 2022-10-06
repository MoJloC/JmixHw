package net.mojloc.jmixhomework.screen.emplyee

import io.jmix.ui.screen.*
import net.mojloc.jmixhomework.entity.Emplyee

@UiController("Emplyee.edit")
@UiDescriptor("emplyee-edit.xml")
@EditedEntityContainer("emplyeeDc")
class EmplyeeEdit : StandardEditor<Emplyee>()