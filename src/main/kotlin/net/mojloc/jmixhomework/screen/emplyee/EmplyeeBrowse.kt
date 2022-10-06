package net.mojloc.jmixhomework.screen.emplyee

import io.jmix.ui.screen.*
import net.mojloc.jmixhomework.entity.Emplyee

@UiController("Emplyee.browse")
@UiDescriptor("emplyee-browse.xml")
@LookupComponent("emplyeesTable")
class EmplyeeBrowse : StandardLookup<Emplyee>()