package org.oooc.kry.user.domain.entity

import java.io.Serializable
import javax.persistence.*


class PermissionPermgroupId(
    val permission: Permission = Permission(),
    val permgroup: Permgroup = Permgroup(),
) : Serializable

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
): Serializable
