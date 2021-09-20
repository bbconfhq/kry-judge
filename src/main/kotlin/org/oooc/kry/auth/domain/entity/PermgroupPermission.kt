package org.oooc.kry.auth.domain.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable
import javax.persistence.*

@Entity
@IdClass(PermgroupPermissionId::class)
class PermgroupPermission (
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permgroup_id", insertable = false, updatable = false)
    val permgroup: Permgroup = Permgroup(),

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    val permission: Permission = Permission()
): Serializable

class PermgroupPermissionId(
    val permgroup: Long = 0,
    val permission: Long = 0,
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PermgroupPermissionId

        if (permgroup != other.permgroup) return false
        if (permission != other.permission) return false

        return true
    }

    override fun hashCode(): Int {
        var result = permgroup.hashCode()
        result = 31 * result + permission.hashCode()
        return result
    }
}
