package net.mojloc.jmixhomework.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.DependsOnProperties
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import io.jmix.data.impl.lazyloading.NotInstantiatedList
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@JmixEntity
@Table(name = "EMPLYEE")
@Entity
open class Emplyee {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Column(name = "VERSION", nullable = false)
    @Version
    var version: Int? = null

    @Column(name = "FIRST_NAME", nullable = false)
    @NotNull
    var firstName: String? = null

    @Column(name = "LAST_NAME", nullable = false)
    @NotNull
    var lastName: String? = null

    @Column(name = "PATRONYMIC")
    var patronymic: String? = null

    @JoinTable(
        name = "PROJECT_EMPLYEE_LINK",
        joinColumns = [JoinColumn(name = "EMPLYEE_ID")],
        inverseJoinColumns = [JoinColumn(name = "PROJECT_ID")]
    )
    @ManyToMany
    var projects: MutableList<Project> = NotInstantiatedList()

    @InstanceName
    @DependsOnProperties("lastName", "firstName")
    fun getInstanceName(): String = "${lastName ?: ""} ${firstName ?: ""}".trim()
}