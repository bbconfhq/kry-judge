package org.oooc.kry.user.domain.entity

import java.io.Serializable
import javax.persistence.*
import org.oooc.global.entity.BaseEntity as BaseEntity

class UserPermissionId(
    val user: User = User(),
    val permission: Permission = Permission()
) : Serializable

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
): BaseEntity()
