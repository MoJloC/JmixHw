package net.mojloc.jmixhomework.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.JmixEntity
import io.jmix.data.impl.lazyloading.NotInstantiatedList
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@JmixEntity
@Table(name = "PROJECT", uniqueConstraints = [
    UniqueConstraint(name = "IDX_PROJECT_UNQ_NAME", columnNames = ["PROJECT_NAME"])
])
@Entity
open class Project {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Column(name = "VERSION", nullable = false)
    @Version
    var version: Int? = null

    @Column(name = "PROJECT_NAME", nullable = false)
    @NotNull
    var projectName: String? = null

    @JoinTable(
        name = "PROJECT_EMPLYEE_LINK",
        joinColumns = [JoinColumn(name = "PROJECT_ID")],
        inverseJoinColumns = [JoinColumn(name = "EMPLYEE_ID")]
    )
    @ManyToMany
    var employees: MutableList<Emplyee> = NotInstantiatedList()
}