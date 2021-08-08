package org.oooc.kry.user.domain.entity

import java.io.Serializable
import javax.persistence.*

@Entity
class Permission (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 191)
    val name: String = "",

    @OneToMany(mappedBy = "permission")
    val userPermissions: List<UserPermission> = emptyList(),

    @OneToMany(mappedBy = "permgroup")
    val PermissionPermgroups: List<PermissionPermgroup> = emptyList(),
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Permission

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}