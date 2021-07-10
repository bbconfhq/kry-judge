package org.oooc.kry.user.domain.entity

import org.oooc.global.entity.BaseEntity
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
    val PermissionPermgroup: List<PermissionPermgroup> = emptyList(),
): BaseEntity()
