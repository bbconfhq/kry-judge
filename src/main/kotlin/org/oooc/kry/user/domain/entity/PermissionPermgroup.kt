package org.oooc.kry.user.domain.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@IdClass(PermissionPermgroupId::class)
class PermissionPermgroup (
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    val permission: Permission = Permission(),

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permgroup_id")
    val permgroup: Permgroup = Permgroup()
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PermissionPermgroup

        if (permission != other.permission) return false
        if (permgroup!= other.permgroup) return false

        return true
    }

    override fun hashCode(): Int {
        var result = permission.hashCode()
        result = 31 * result + permgroup.hashCode()
        return result
    }
}

class PermissionPermgroupId(
    val permission: Permission = Permission(),
    val permgroup: Permgroup = Permgroup(),
) : Serializable