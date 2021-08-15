package org.oooc.kry.user.domain.entity

import org.oooc.kry.auth.domain.entity.Permission
import java.io.Serializable
import javax.persistence.*

@Entity
@IdClass(UserPermissionId::class)
class UserPermission(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User = User(),

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    val permission: Permission = Permission()
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserPermission

        if (user != other.user) return false
        if (permission != other.permission) return false

        return true
    }

    override fun hashCode(): Int {
        var result = user.hashCode()
        result = 31 * result + permission.hashCode()
        return result
    }
}

class UserPermissionId(
    val user: User = User(),
    val permission: Permission = Permission()
) : Serializable
